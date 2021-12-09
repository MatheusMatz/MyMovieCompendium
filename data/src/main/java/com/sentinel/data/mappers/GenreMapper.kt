package com.sentinel.data.mappers

import com.sentinel.core.utils.BaseMapper
import com.sentinel.data.datasource.local.entities.GenreEntity
import com.sentinel.data.models.Genre

class GenreMapper : BaseMapper<GenreEntity, Genre>() {

    override fun transform(entity: GenreEntity): Genre {
        return Genre(id = entity.id, name = entity.name)
    }
}