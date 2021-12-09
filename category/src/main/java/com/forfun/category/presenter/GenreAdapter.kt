package com.forfun.category.presenter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.forfun.category.databinding.ViewHolderCategoryBinding
import com.forfun.category.domain.GenreVO

class GenreAdapter : ListAdapter<GenreVO, GenreViewHolder>(object :
    DiffUtil.ItemCallback<GenreVO>() {
    override fun areItemsTheSame(oldItem: GenreVO, newItem: GenreVO): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: GenreVO, newItem: GenreVO): Boolean {
        return oldItem == newItem
    }
}) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreViewHolder {
        val binding =
            ViewHolderCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GenreViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GenreViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
