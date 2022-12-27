package com.manpro.todo.ui.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.binar.secondhand.kel2.data.resource.Resource
import com.manpro.todo.data.api.model.auth.register.PostRegisterRequest
import com.manpro.todo.data.api.model.auth.register.PostRegisterResponse
import com.manpro.todo.data.repository.auth.AuthRepository
import com.manpro.todo.utils.RunCatchingUtil
import kotlinx.coroutines.launch
import retrofit2.Response

class RegisterVideModel(private val repository: AuthRepository): ViewModel() {

    private val _postRegisterResponse = MutableLiveData<Resource<Response<PostRegisterResponse>>>()
    val postRegisterResponse: LiveData<Resource<Response<PostRegisterResponse>>> get() = _postRegisterResponse

    fun postRegister(request: PostRegisterRequest){
        viewModelScope.launch {
            RunCatchingUtil.call(
                data = _postRegisterResponse,
                apiCall = {
                    repository.postRegister(request)
                }
            )
        }
    }

}