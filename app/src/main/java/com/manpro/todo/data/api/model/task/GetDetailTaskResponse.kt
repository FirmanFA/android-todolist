package com.manpro.todo.data.api.model.task


import com.google.gson.annotations.SerializedName

data class GetDetailTaskResponse(
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
        val id: String,
        @SerializedName("title")
        val title: String,
        @SerializedName("content")
        val content: String,
        @SerializedName("labels")
        val labels: List<Label>,
        @SerializedName("reminders")
        val reminders: List<Reminder>,
        @SerializedName("created_at")
        val createdAt: String,
        @SerializedName("updated_at")
        val updatedAt: String
    ) {
        data class Label(
            @SerializedName("id")
            val id: String,
            @SerializedName("title")
            val title: String,
            @SerializedName("color")
            val color: String
        )

        data class Reminder(
            @SerializedName("id")
            val id: String,
            @SerializedName("datetime")
            val datetime: String
        )
    }
}