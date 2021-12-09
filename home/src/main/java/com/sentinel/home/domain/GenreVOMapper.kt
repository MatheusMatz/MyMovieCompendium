package com.sentinel.home.domain

import com.forfun.category.domain.GenreVO
import com.sentinel.core.utils.BaseMapper
import com.sentinel.domain.dtos.GenreDTO

class GenreVOMapper: BaseMapper<GenreDTO, GenreVO>() {
    override fun transform(entity: GenreDTO): GenreVO {
        return GenreVO(entity.name)
    }
}