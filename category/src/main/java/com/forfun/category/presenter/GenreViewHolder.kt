package com.forfun.category.presenter

import androidx.recyclerview.widget.RecyclerView
import com.forfun.category.databinding.ViewHolderCategoryBinding
import com.forfun.category.domain.GenreVO

class GenreViewHolder(private val binding: ViewHolderCategoryBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(genreVO: GenreVO) {
        binding.genreName.text = genreVO.name
    }
}