package com.sentinel.data.datasource

import com.sentinel.core.Resource

suspend fun <T, A> performGetOperation(
    databaseQuery: () -> T,
    networkCall: suspend () -> Resource<A>,
    saveCallResult: suspend (A) -> Unit
): Resource<T> {

    val source = databaseQuery.invoke()

    val responseStatus = networkCall.invoke()
    if(responseStatus.status == Resource.Status.SUCCESS) {
        saveCallResult(responseStatus.data!!)
    } else if(responseStatus.status == Resource.Status.ERROR) {
        return Resource.error(responseStatus.message!!, source)
    }

    return Resource.success(source)
}

