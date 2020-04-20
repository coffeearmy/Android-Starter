package com.example.androidstarter.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.androidstarter.App
import com.example.androidstarter.databinding.ListBinding
import javax.inject.Inject

class ListActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel: ListViewModel
    private lateinit var binding: ListBinding
    private lateinit var adapterEntry: EntryListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as App)
            .appComponent.listComponent().create().inject(this)

        super.onCreate(savedInstanceState)
        binding = ListBinding.inflate(layoutInflater)

        setContentView(binding.root)

        adapterEntry = EntryListAdapter()
        binding.list.apply {
            layoutManager = GridLayoutManager(this@ListActivity, 3, RecyclerView.VERTICAL, false)
            adapter = adapterEntry
        }

        viewModel = ViewModelProvider(this, viewModelFactory).get(ListViewModel::class.java)
        viewModel.getPlantList()
        viewModel.plantListState.observe(this, Observer { state -> handleState(state) })
    }

    private fun handleState(state: ListViewModel.ViewState?) {
       when(state){
           ListViewModel.ViewState.Loading -> nothingForNow()
           ListViewModel.ViewState.Error -> nothingForNow()
           is ListViewModel.ViewState.Success -> {
               adapterEntry.setItems(state.list)
               adapterEntry.notifyDataSetChanged()
           }
           null -> nothingForNow()
       }
    }
    private fun nothingForNow() {

    }
}

