package com.example.androidstarter.features.list.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidstarter.App
import com.example.androidstarter.databinding.ListPlantsBinding
import javax.inject.Inject

class PlantListActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel: PlantListViewModel
    private lateinit var binding: ListPlantsBinding
    private lateinit var adapterPlant: PlantListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as App).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        binding = ListPlantsBinding.inflate(layoutInflater)

        setContentView(binding.root)
        adapterPlant = PlantListAdapter()
        binding.plantList.apply {
            layoutManager = LinearLayoutManager(this@PlantListActivity)
            adapter = adapterPlant
        }

        viewModel = ViewModelProvider(this, viewModelFactory).get(PlantListViewModel::class.java)
        viewModel.getPlantList()
        viewModel.plantListState.observe(this, Observer { state -> handleState(state) })
    }

    private fun handleState(state: PlantListViewModel.ViewState?) {
       when(state){
           PlantListViewModel.ViewState.Loading -> nothingForNow()
           PlantListViewModel.ViewState.Error -> nothingForNow()
           is PlantListViewModel.ViewState.Success -> {
               adapterPlant.setItems(state.list)
               adapterPlant.notifyDataSetChanged()
           }
           null -> nothingForNow()
       }
    }
    private fun nothingForNow() {

    }
}

