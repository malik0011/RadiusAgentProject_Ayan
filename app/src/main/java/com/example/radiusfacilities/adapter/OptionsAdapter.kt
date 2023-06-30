package com.example.radiusfacilities.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.radiusfacilities.databinding.ItemOptionBinding
import com.example.radiusfacilities.model.Option
import com.example.radiusfacilities.utils.ResourceUtils

class OptionsAdapter : androidx.recyclerview.widget.ListAdapter<Option, OptionsAdapter.OptionViewHolder>(OptionDiff()) {

    class OptionViewHolder(private val binding: ItemOptionBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Option) {
            binding.name.text  = item.name
            binding.icon.setImageResource(ResourceUtils.getResourceId(item.icon))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OptionViewHolder {
        val binding = ItemOptionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OptionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OptionViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}

    private class OptionDiff : DiffUtil.ItemCallback<Option>() {

        override fun areItemsTheSame(oldItem: Option, newItem: Option): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Option, newItem: Option): Boolean {
            return oldItem == newItem
        }
    }
