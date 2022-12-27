package com.manpro.todo.data.api.model.auth.register


import com.google.gson.annotations.SerializedName

data class PostRegisterResponse(
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
        @SerializedName("user_id")
        val userId: String,
        @SerializedName("email")
        val email: String,
        @SerializedName("token")
        val token: String
    )
}