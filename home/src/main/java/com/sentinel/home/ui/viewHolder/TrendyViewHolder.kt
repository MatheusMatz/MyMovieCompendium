package com.sentinel.home.ui.viewHolder

import androidx.recyclerview.widget.RecyclerView
import com.sentinel.core.ext.loadImage
import com.sentinel.domain.dtos.MovieDTO
import com.sentinel.home.databinding.ViewHolderHighlightBinding

class TrendyViewHolder(private val highlightBinding: ViewHolderHighlightBinding) :
    RecyclerView.ViewHolder(highlightBinding.root) {

        fun bind(movieDTO: MovieDTO) {
            movieDTO.backdrop_path?.let {
                highlightBinding.highlightPoster.loadImage(it)
            }
        }
}