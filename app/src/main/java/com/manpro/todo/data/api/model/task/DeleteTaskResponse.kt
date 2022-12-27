package com.manpro.todo.data.api.model.task


import com.google.gson.annotations.SerializedName

data class DeleteTaskResponse(
    @SerializedName("meta")
    val meta: Meta
) {
    data class Meta(
        @SerializedName("code")
        val code: Int,
        @SerializedName("message")
        val message: String
    )
}