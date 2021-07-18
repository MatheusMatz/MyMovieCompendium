package com.sentinel.data.mappers

import com.sentinel.core.utils.BaseMapper
import com.sentinel.data.datasource.local.entities.MovieEntity
import com.sentinel.data.datasource.remote.responses.MovieResponse
import com.sentinel.data.models.Popularity

class MovieEntityMapper : BaseMapper<MovieResponse, MovieEntity>() {

    private var isTrendy: Boolean = false

    override fun transform(entity: MovieResponse): MovieEntity {
        return MovieEntity(
            id = entity.id,
            title = entity.title ?: "",
            original_language = entity.original_language,
            original_title = entity.original_title ?: "",
            poster_path = entity.poster_path,
            vote_count = entity.vote_count,
            overview = entity.overview,
            release_date = entity.release_date ?: "",
            vote_average = entity.vote_average,
            video = entity.video,
            adult = entity.adult,
            backdrop_path = entity.backdrop_path ?: "",
            popularity = entity.popularity,
            isTrendy = isTrendy
        )
    }

    fun checkIsTrendy(isTrendy: Boolean) {
        this.isTrendy = isTrendy
    }

}
