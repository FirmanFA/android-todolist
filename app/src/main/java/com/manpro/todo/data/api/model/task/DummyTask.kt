package com.manpro.todo.data.api.model.task

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DummyTask(

    val title:String,
    val content:String,
    val date: String,
    val label: String

) : Parcelable