package com.manpro.todo.data.api.service

import com.manpro.todo.data.api.model.auth.login.PostLoginRequest
import com.manpro.todo.data.api.model.auth.login.PostLoginResponse
import com.manpro.todo.data.api.model.auth.logout.GetLogoutResponse
import com.manpro.todo.data.api.model.auth.register.PostRegisterRequest
import com.manpro.todo.data.api.model.auth.register.PostRegisterResponse
import com.manpro.todo.data.api.model.task.*
import retrofit2.Response
import retrofit2.http.*


class ApiHelper(private val apiService: ApiService) {


    suspend fun postLogin(request: PostLoginRequest): Response<PostLoginResponse> =
        apiService.postLogin(request)


    suspend fun postRegister(request: PostRegisterRequest): Response<PostRegisterResponse> =
        apiService.postRegister(request)


    suspend fun getLogout(): Response<GetLogoutResponse> = apiService.getLogout()

    //task

    suspend fun getAllTasks(): Response<GetAllTaskResponse> = apiService.getAllTasks()


    suspend fun getTaskById(id: String): Response<GetDetailTaskResponse> =
        apiService.getTaskById(id)


    suspend fun postNewTask(request: PostNewTaskRequest): Response<PostTaskResponse> =
        apiService.postNewTask(request)

    suspend fun putTask(
        id: String,
        request: PutTaskRequest
    ): Response<PutTaskResponse> = apiService.putTask(id, request)

    suspend fun deleteTask(id: String): Response<DeleteTaskResponse> = apiService.deleteTask(id)

}