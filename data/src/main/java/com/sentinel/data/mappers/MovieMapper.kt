package com.sentinel.data.mappers

import com.sentinel.core.utils.BaseMapper
import com.sentinel.data.datasource.local.entities.MovieEntity
import com.sentinel.data.models.Movie

class MovieMapper : BaseMapper<MovieEntity, Movie>() {

    override fun transform(entity: MovieEntity): Movie {
        return Movie(
            id = entity.id,
            title = entity.title,
            original_language = entity.original_language,
            original_title = entity.original_title,
            poster_path = entity.poster_path,
            vote_count = entity.vote_count,
            overview = entity.overview,
            release_date = entity.release_date,
            vote_average = entity.vote_average,
            video = entity.video,
            adult = entity.adult,
            backdrop_path = entity.backdrop_path,
            popularity = entity.popularity,
            isTrendy = entity.isTrendy
        )
    }
}
