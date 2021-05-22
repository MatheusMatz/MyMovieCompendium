package com.sentinel.core.utils

abstract class BaseMapper<IN, OUT> {

    abstract fun transform(entity: IN): OUT

    fun transform(entities: List<IN>?): List<OUT> {
        return entities?.let { list ->
            list.map(::transform)
        } ?: emptyList()
    }
}
