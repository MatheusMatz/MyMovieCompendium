package com.sentinel.home.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sentinel.domain.dtos.MovieDTO
import com.sentinel.home.databinding.ViewHolderMoviePreviewBinding
import com.sentinel.home.ui.viewHolder.PreviewMovieViewHolder

class PopularAdapter : RecyclerView.Adapter<PreviewMovieViewHolder>() {

    private var movieList = mutableListOf<MovieDTO>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PreviewMovieViewHolder {
        val binding =
            ViewHolderMoviePreviewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )

        return PreviewMovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PreviewMovieViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    override fun getItemCount() = movieList.size

    fun setMovieList(list: List<MovieDTO>) {
        movieList.clear()
        movieList.addAll(list)
        notifyDataSetChanged()
    }
}
