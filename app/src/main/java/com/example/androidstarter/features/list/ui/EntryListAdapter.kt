package com.example.androidstarter.features.list.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidstarter.databinding.ListItemBinding
import com.example.androidstarter.features.list.domain.model.Entry

class EntryListAdapter : RecyclerView.Adapter<EntryListAdapter.EntryViewHolder>() {
    val list: MutableList<Entry> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntryViewHolder =
        EntryViewHolder(
            ListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: EntryViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun setItems(list: List<Entry>) {
        this.list.addAll(list)
    }

    class EntryViewHolder(
        private val binding: ListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(entry: Entry) {
            Glide.with(binding.imageItem).load(entry.regularUrl).into(binding.imageItem)
        }
    }
}