package com.sentinel.domain.mappers

import com.sentinel.core.utils.BaseMapper
import com.sentinel.data.datasource.remote.responses.MovieResponse
import com.sentinel.data.models.Movie
import com.sentinel.domain.dtos.MovieDTO

class MovieMapper: BaseMapper<Movie, MovieDTO>() {

    override fun transform(entity: Movie): MovieDTO {
        return MovieDTO(
            title = entity.title,
            poster_path = entity.poster_path,
            backdrop_path = entity.backdrop_path,
            vote_count = entity.vote_count,
            overview = entity.overview,
            release_date = entity.release_date,
            vote_average = entity.vote_average,
            id = entity.id,
            adult = entity.adult
        )
    }
}
