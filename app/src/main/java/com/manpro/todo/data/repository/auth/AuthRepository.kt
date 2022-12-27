package com.manpro.todo.data.repository.auth

import com.manpro.todo.data.api.model.auth.login.PostLoginRequest
import com.manpro.todo.data.api.model.auth.login.PostLoginResponse
import com.manpro.todo.data.api.model.auth.logout.GetLogoutResponse
import com.manpro.todo.data.api.model.auth.register.PostRegisterRequest
import com.manpro.todo.data.api.model.auth.register.PostRegisterResponse
import com.manpro.todo.data.api.service.ApiHelper
import retrofit2.Response

class AuthRepository(private val apiHelper: ApiHelper) {

    suspend fun postLogin(request: PostLoginRequest): Response<PostLoginResponse> =
        apiHelper.postLogin(request)


    suspend fun postRegister(request: PostRegisterRequest): Response<PostRegisterResponse> =
        apiHelper.postRegister(request)


    suspend fun getLogout(): Response<GetLogoutResponse> = apiHelper.getLogout()

}