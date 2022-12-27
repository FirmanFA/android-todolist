package com.manpro.todo.data.api.model.auth.register


import com.google.gson.annotations.SerializedName

data class PostRegisterRequest(
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("password_confirmation")
    val passwordConfirmation: String
)