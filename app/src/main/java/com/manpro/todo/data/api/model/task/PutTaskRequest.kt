package com.manpro.todo.data.api.model.task


import com.google.gson.annotations.SerializedName

data class PutTaskRequest(
    @SerializedName("title")
    val title: String,
    @SerializedName("content")
    val content: String,
    @SerializedName("label_ids")
    val labelIds: List<String>,
    @SerializedName("reminders")
    val reminders: List<Reminder>
) {
    data class Reminder(
        @SerializedName("datetime")
        val datetime: String
    )
}