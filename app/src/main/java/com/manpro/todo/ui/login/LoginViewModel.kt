package com.manpro.todo.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.binar.secondhand.kel2.data.resource.Resource
import com.manpro.todo.data.api.model.auth.login.PostLoginRequest
import com.manpro.todo.data.api.model.auth.login.PostLoginResponse
import com.manpro.todo.data.repository.auth.AuthRepository
import com.manpro.todo.utils.RunCatchingUtil
import kotlinx.coroutines.launch
import retrofit2.Response

class LoginViewModel(private val repository: AuthRepository): ViewModel() {


    private val _postLoginResponse = MutableLiveData<Resource<Response<PostLoginResponse>>>()
    val postLoginResponse: LiveData<Resource<Response<PostLoginResponse>>> get() = _postLoginResponse

    fun postLogin(request: PostLoginRequest){
        viewModelScope.launch {
            RunCatchingUtil.call(
                data = _postLoginResponse,
                apiCall = {
                    repository.postLogin(request)
                }
            )
        }
    }


}