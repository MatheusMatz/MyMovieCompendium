package com.sentinel.data.datasource.remote.responses

import com.sentinel.data.models.Provider

data class ProviderResponse(
    val BR: Provider,
    val CA: Provider,
    val US: Provider
)
