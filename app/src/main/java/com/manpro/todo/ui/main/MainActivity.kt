package com.manpro.todo.ui.main

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.view.menu.MenuBuilder
import androidx.appcompat.widget.PopupMenu
import com.manpro.todo.R
import com.manpro.todo.data.api.model.task.DummyTask
import com.manpro.todo.databinding.ActivityMainBinding
import com.manpro.todo.ui.base.BaseActivity
import com.manpro.todo.ui.detail.task.DetailTaskActivity
import com.manpro.todo.ui.main.content.calendar.CalendarFragment
import com.manpro.todo.ui.main.content.task.TaskMainFragment
import com.manpro.todo.utils.DatePickerFragment
import com.manpro.todo.utils.showIcons


class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getViewBinding() = ActivityMainBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        binding.botNavMain.setOnItemSelectedListener {

            when (it.itemId) {

                R.id.menu_task_list -> {
                    this.supportFragmentManager.beginTransaction()
                        .replace(R.id.frag_cont_main, TaskMainFragment())
                        .commit()

                    true
                }

                R.id.menu_calendar -> {
                    this.supportFragmentManager.beginTransaction()
                        .replace(R.id.frag_cont_main, CalendarFragment())
                        .commit()

                    true
                }

                else -> false

            }

        }

        binding.fabAddTask.setOnClickListener {
            binding.groupAddTask.visibility = View.GONE
            binding.containerAddTask.visibility = View.VISIBLE

            binding.etTaskTitle.editText?.requestFocus()
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(binding.etTaskTitle.editText, InputMethodManager.SHOW_IMPLICIT)
        }

        binding.etTaskTitle.editText?.setOnFocusChangeListener { _, isFocused ->
            if (!isFocused) {
                binding.groupAddTask.visibility = View.VISIBLE
                binding.containerAddTask.visibility = View.GONE
            }
        }

        binding.btnTaskDate.setOnClickListener {
            DatePickerFragment{
                binding.tvDate.text = it
            }.show(supportFragmentManager,"datePicker")
        }

        binding.btnTaskLabel.setOnClickListener {
            val popupMenu = PopupMenu(this, it)
            popupMenu.menu.showIcons()

            val menu1 = popupMenu.menu.add("Done")
            menu1.setIcon(R.drawable.ic_task_label)
            menu1.icon.setTint(Color.parseColor("#158700"))
            val menu2 = popupMenu.menu.add("Cancel")
            menu2.setIcon(R.drawable.ic_task_label)
            menu2.icon.setTint(Color.parseColor("#FFDF0000"))
            val menu3 = popupMenu.menu.add("OnGoing")
            menu3.setIcon(R.drawable.ic_task_label)
            menu3.icon.setTint(Color.parseColor("#0036F4"))
            popupMenu.show()

            val listColor = listOf("#158700", "#FFDF0000","#0036F4")

            popupMenu.setOnMenuItemClickListener { menuItem ->
                binding.tvLabel.text = menuItem.title
                binding.btnTaskLabel.setColorFilter(Color.parseColor(listColor[menuItem.order]))
                true
            }
        }

        binding.btnSentTask.setOnClickListener {

            //do insert
            binding.etTaskTitle.editText?.clearFocus()
            binding.fragContMain.requestFocus()
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(
                currentFocus?.windowToken,
                InputMethodManager.HIDE_NOT_ALWAYS
            )
            val intent = Intent(this, DetailTaskActivity::class.java)
            val data = DummyTask(
                binding.etTaskTitle.editText?.text.toString(),
                "",
                "2022-12-27",
                "#158700"
            )
            intent.putExtra("task", data)
            startActivity(intent)
            DetailTaskActivity.isDeleted = false

        }
    }

}