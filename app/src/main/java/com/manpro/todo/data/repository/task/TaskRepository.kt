package com.manpro.todo.data.repository.task

import com.manpro.todo.data.api.model.task.*
import com.manpro.todo.data.api.service.ApiHelper
import retrofit2.Response

class TaskRepository(private val apiHelper: ApiHelper) {


    suspend fun getAllTasks(): Response<GetAllTaskResponse> = apiHelper.getAllTasks()


    suspend fun getTaskById(id: String): Response<GetDetailTaskResponse> =
        apiHelper.getTaskById(id)


    suspend fun postNewTask(request: PostNewTaskRequest): Response<PostTaskResponse> =
        apiHelper.postNewTask(request)

    suspend fun putTask(
        id: String,
        request: PutTaskRequest
    ): Response<PutTaskResponse> = apiHelper.putTask(id, request)

    suspend fun deleteTask(id: String): Response<DeleteTaskResponse> = apiHelper.deleteTask(id)

}