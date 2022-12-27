package com.manpro.todo.data.api.model.task


import com.google.gson.annotations.SerializedName

data class PutTaskResponse(
    @SerializedName("meta")
    val meta: Meta,
    @SerializedName("errors")
    val errors: List<Error>
) {
    data class Meta(
        @SerializedName("code")
        val code: Int,
        @SerializedName("message")
        val message: String
    )

    data class Error(
        @SerializedName("title")
        val title: List<String>
    )
}