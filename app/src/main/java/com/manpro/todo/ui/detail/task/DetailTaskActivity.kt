package com.manpro.todo.ui.detail.task

import android.app.AlertDialog
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.widget.PopupMenu
import com.manpro.todo.R
import com.manpro.todo.data.api.model.task.DummyTask
import com.manpro.todo.databinding.ActivityDetailTaskBinding
import com.manpro.todo.ui.base.BaseActivity
import com.manpro.todo.ui.detail.task.reminder.ReminderFragment
import com.manpro.todo.ui.main.content.calendar.CalendarFragment
import com.manpro.todo.ui.main.content.task.TaskMainFragment
import com.manpro.todo.utils.showIcons

class DetailTaskActivity : BaseActivity<ActivityDetailTaskBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val task = intent.getParcelableExtra<DummyTask>("task")

        binding.tvTaskTitle.text = task?.title
        binding.btnLabel.setColorFilter(Color.parseColor(task?.label))
        binding.tvTaskDate.text = task?.date
        binding.etTaskContent.setText(task?.content)


        binding.btnLabel.setOnClickListener {

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
                binding.btnLabel.setColorFilter(Color.parseColor(listColor[menuItem.order]))
                true
            }

        }

        binding.botNavMain.setOnItemSelectedListener {

            when (it.itemId) {

                R.id.menu_reminder_task -> {

                    ReminderFragment().show(supportFragmentManager, "setReminder")

                    true
                }

                R.id.menu_delete_task -> {

                    AlertDialog.Builder(this).apply {
                        setTitle("Delete Task")
                        setMessage("Are you sure want to delete this task?")
                        setPositiveButton("Delete") { dialog, _ ->

                            //do delete

                            dialog.dismiss()
                            finish()
                            isDeleted = true

                        }
                        setNegativeButton("Cancel"){dialog, _ ->
                            dialog.dismiss()
                        }

                        create()
                        show()
                    }

                    true
                }

                else -> false

            }

        }


    }

    override fun getViewBinding(): ActivityDetailTaskBinding =
        ActivityDetailTaskBinding.inflate(layoutInflater)

    companion object{
        var isDeleted = false
    }
}