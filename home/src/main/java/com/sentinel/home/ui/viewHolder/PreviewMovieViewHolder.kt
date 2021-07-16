package com.sentinel.home.ui.viewHolder

import androidx.recyclerview.widget.RecyclerView
import com.sentinel.core.ext.loadImage
import com.sentinel.domain.dtos.MovieDTO
import com.sentinel.home.databinding.ViewHolderMoviePreviewBinding

class PreviewMovieViewHolder(private val binding: ViewHolderMoviePreviewBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(movieDTO: MovieDTO) {

        with(binding) {
            moviePreviewPoster.loadImage(movieDTO.poster_path.toString())
            moviePreviewTitle.text = movieDTO.title
            moviePreviewRate.text = movieDTO.vote_average.toString()
            moviePreviewRateBar.rating = movieDTO.vote_average!!
        }
    }
}
