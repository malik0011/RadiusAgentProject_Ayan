package com.example.radiusfacilities.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.radiusfacilities.databinding.ItemFacilitesBinding
import com.example.radiusfacilities.model.Facility

class FacilitiesAdapter() : androidx.recyclerview.widget.ListAdapter<Facility, FacilitiesAdapter.FacilitiesViewHolder>(DiffCallback()) {

    class FacilitiesViewHolder(private val binding: ItemFacilitesBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Facility) {
            binding.tvFacilitiesName.text  = item.name
            binding.rcvOption.layoutManager = LinearLayoutManager(binding.root.context)
            val optionsAdapter = OptionsAdapter()
            binding.rcvOption.adapter = optionsAdapter
            optionsAdapter.submitList(item.options)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FacilitiesViewHolder {
        val binding = ItemFacilitesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FacilitiesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FacilitiesViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}

    private class DiffCallback : DiffUtil.ItemCallback<Facility>() {
        override fun areItemsTheSame(oldItem: Facility, newItem: Facility): Boolean {
            return oldItem.facility_id == newItem.facility_id
        }

        override fun areContentsTheSame(oldItem: Facility, newItem: Facility): Boolean {
            return oldItem == newItem
        }
    }
