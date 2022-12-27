package com.manpro.todo.ui.main.content.calendar

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.manpro.todo.R
import com.manpro.todo.databinding.FragmentCalendarBinding
import com.manpro.todo.ui.base.BaseFragment
import com.manpro.todo.ui.detail.task.DetailTaskActivity
import com.manpro.todo.ui.main.content.task.TaskListAdapter
import com.manpro.todo.utils.BounceEdgeEffectFactory
import com.manpro.todo.utils.taskList
import com.manpro.todo.utils.taskListDelete

class CalendarFragment : BaseFragment<FragmentCalendarBinding>(FragmentCalendarBinding::inflate) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvAdapter = TaskListAdapter {
            val intent = Intent(context, DetailTaskActivity::class.java)
            intent.putExtra("task", it)
            startActivity(intent)
        }

        val listString = listOf("Todo saya", "Kuliah Pagi", "Bersih Bersih", "Belajar", "Ngoding")

        binding.rvTaskList.apply {
            adapter = rvAdapter
            edgeEffectFactory = BounceEdgeEffectFactory()
        }

        if (DetailTaskActivity.isDeleted){
            rvAdapter.submitList(taskListDelete)
        }else{
            rvAdapter.submitList(taskList)
        }

        binding.calendarView.setOnDateChangeListener { _, i, i2, i3 ->

//            Toast.makeText(context, "tahun $i bulan ${i2+1} tanggal $i3", Toast.LENGTH_SHORT).show()

            if (i3 != 27){
//                binding.rvTaskList.visibility = View.INVISIBLE
                rvAdapter.submitList(listOf())
            }else{
//                binding.rvTaskList.visibility = View.VISIBLE
                rvAdapter.submitList(taskList)
            }

        }


    }

}