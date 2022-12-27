package com.manpro.todo.data.api.model.task


import com.google.gson.annotations.SerializedName

data class GetAllTaskResponse(
    @SerializedName("meta")
    val meta: Meta,
    @SerializedName("data")
    val `data`: List<Data>
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
        @SerializedName("labels")
        val labels: List<Label>,
        @SerializedName("nearest_reminder")
        val nearestReminder: NearestReminder,
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

        data class NearestReminder(
            @SerializedName("id")
            val id: String,
            @SerializedName("datetime")
            val datetime: String
        )
    }
}