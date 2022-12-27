package com.manpro.todo.utils

import android.annotation.SuppressLint
import android.view.Menu
import androidx.appcompat.view.menu.MenuBuilder

@SuppressLint("RestrictedApi")
fun Menu.showIcons() {
    (this as? MenuBuilder)?.setOptionalIconsVisible(true)
}