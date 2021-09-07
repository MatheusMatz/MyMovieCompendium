package com.sentinel.home.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sentinel.domain.dtos.MovieDTO
import com.sentinel.home.databinding.ViewHolderHighlightBinding
import com.sentinel.home.ui.viewHolder.TrendyViewHolder

class TrendyAdapter :  RecyclerView.Adapter<TrendyViewHolder>() {

    private var trendyMovieList = mutableListOf<MovieDTO>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendyViewHolder {
        val highlightBinding =
            ViewHolderHighlightBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TrendyViewHolder(highlightBinding)
    }

    override fun onBindViewHolder(holder: TrendyViewHolder, position: Int) {
        holder.bind(trendyMovieList[position])
    }

    override fun getItemCount() = trendyMovieList.size

    @SuppressLint("NotifyDataSetChanged")
    fun addTrendyMovies(movieList: List<MovieDTO>) {
        trendyMovieList.clear()
        trendyMovieList.addAll(movieList)
        notifyDataSetChanged()
    }
}
