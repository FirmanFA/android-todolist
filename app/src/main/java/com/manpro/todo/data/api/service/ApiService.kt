package com.manpro.todo.data.api.service

import com.manpro.todo.data.api.model.auth.login.PostLoginRequest
import com.manpro.todo.data.api.model.auth.login.PostLoginResponse
import com.manpro.todo.data.api.model.auth.logout.GetLogoutResponse
import com.manpro.todo.data.api.model.auth.register.PostRegisterRequest
import com.manpro.todo.data.api.model.auth.register.PostRegisterResponse
import com.manpro.todo.data.api.model.task.*
import retrofit2.Response
import retrofit2.http.*

interface ApiService {


    //auth
    @POST("auth/sign-in")
    suspend fun postLogin(@Body request: PostLoginRequest): Response<PostLoginResponse>

    @POST("auth/sign-up")
    suspend fun postRegister(@Body request: PostRegisterRequest): Response<PostRegisterResponse>

    @GET("auth/sign-out")
    suspend fun getLogout(): Response<GetLogoutResponse>

    //task
    @GET("tasks")
    suspend fun getAllTasks(): Response<GetAllTaskResponse>

    @GET("tasks/{task_id}")
    suspend fun getTaskById(@Path("task_id") id: String): Response<GetDetailTaskResponse>

    @POST("tasks")
    suspend fun postNewTask(@Body request: PostNewTaskRequest): Response<PostTaskResponse>

    @PUT("tasks/{task_id}")
    suspend fun putTask(
        @Path("task_id") id: String,
        @Body request: PutTaskRequest
    ): Response<PutTaskResponse>

    @DELETE("tasks/{task_id}")
    suspend fun deleteTask(@Path("task_id") id: String): Response<DeleteTaskResponse>


}