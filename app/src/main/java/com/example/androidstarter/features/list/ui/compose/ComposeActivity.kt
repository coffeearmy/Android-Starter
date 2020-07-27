package com.example.androidstarter.features.list.ui.compose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.Composable
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.ui.core.setContent
import androidx.ui.foundation.Text
import com.example.androidstarter.App
import com.example.androidstarter.features.list.ui.ListViewModel
import javax.inject.Inject

class ComposeActivity : AppCompatActivity() {

    @Inject
    lateinit var adapter: EntryListCompositeAdapter

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel: ListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as App).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory).get(ListViewModel::class.java)
        viewModel.getPlantList()
        viewModel.plantListState.observe(this, Observer { state -> handleState(state) })

        setContent {
            adapter.adapterListAdapter()
        }
    }

    private fun handleState(state: ListViewModel.ViewState?) {
        when(state){
            ListViewModel.ViewState.Loading -> nothingForNow()
            ListViewModel.ViewState.Error -> nothingForNow()
            is ListViewModel.ViewState.Success -> {
                adapter.setItems(state.list)
            }
            null -> nothingForNow()
        }
    }

    private fun nothingForNow() {
    }
}