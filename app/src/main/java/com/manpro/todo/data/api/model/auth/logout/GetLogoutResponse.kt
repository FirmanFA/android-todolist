package com.manpro.todo.data.api.model.auth.logout


import com.google.gson.annotations.SerializedName

data class GetLogoutResponse(
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