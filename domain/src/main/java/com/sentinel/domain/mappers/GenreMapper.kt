package com.sentinel.domain.mappers

import com.sentinel.core.utils.BaseMapper
import com.sentinel.data.models.Genre
import com.sentinel.domain.dtos.GenreDTO

class GenreMapper : BaseMapper<Genre, GenreDTO>() {
    override fun transform(entity: Genre): GenreDTO {
        return GenreDTO(id = entity.id, name = entity.name)
    }
}