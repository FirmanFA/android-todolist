package com.manpro.todo.utils

import androidx.lifecycle.MutableLiveData
import com.binar.secondhand.kel2.data.resource.Resource
import retrofit2.Response

object RunCatchingUtil {

    suspend fun <T> call(
        data: MutableLiveData<Resource<Response<T>>>,
        apiCall: suspend () -> Response<T>
    ) {

        data.postValue(Resource.loading())

        kotlin.runCatching {
            Resource.success(apiCall.invoke())
        }.onSuccess {
            data.postValue(it)
        }.onFailure {
            data.postValue(
                Resource.error(
                    it.localizedMessage
                        ?: "Error occured"
                )
            )
        }
    }

}