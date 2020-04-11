package com.example.androidstarter.features.list.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidstarter.databinding.ListItemPlantNameBinding
import com.example.androidstarter.features.list.domain.model.Plant

class PlantListAdapter : RecyclerView.Adapter<PlantListAdapter.PlantViewHolder>() {
    val list: MutableList<Plant> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantViewHolder =
        PlantViewHolder(
            ListItemPlantNameBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int = list.size
    override fun onBindViewHolder(holder: PlantViewHolder, position: Int) {
        val plant = list[position]
        holder.bind(plant)
    }

    fun setItems(list: List<Plant>) {
        this.list.clear()
        this.list.addAll(list)
    }

    class PlantViewHolder(
        private val binding: ListItemPlantNameBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(plant: Plant) {
            binding.plantName.text = plant.name
        }
    }
}