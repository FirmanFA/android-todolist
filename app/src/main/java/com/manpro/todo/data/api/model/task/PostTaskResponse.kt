package com.manpro.todo.data.api.model.task


import com.google.gson.annotations.SerializedName

data class PostTaskResponse(
    @SerializedName("meta")
    val meta: Meta,
    @SerializedName("data")
    val `data`: Data
) {
    data class Meta(
        @SerializedName("code")
        val code: Int,
        @SerializedName("message")
        val message: String
    )

    data class Data(
        @SerializedName("id")
        val id: String
    )
}