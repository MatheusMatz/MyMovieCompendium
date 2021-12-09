package com.sentinel.data.mappers

import com.sentinel.core.utils.BaseMapper
import com.sentinel.data.datasource.local.entities.GenreEntity
import com.sentinel.data.datasource.remote.responses.GenreResponse

class GenreEntityMapper : BaseMapper<GenreResponse, GenreEntity>() {

    override fun transform(entity: GenreResponse): GenreEntity {
        return GenreEntity(id = entity.id, entity.name)
    }
}