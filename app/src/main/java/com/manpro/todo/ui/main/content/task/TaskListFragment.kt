package com.manpro.todo.ui.main.content.task

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.RecyclerView
import com.manpro.todo.R
import com.manpro.todo.databinding.FragmentTaskListBinding
import com.manpro.todo.ui.base.BaseFragment
import com.manpro.todo.ui.detail.task.DetailTaskActivity
import com.manpro.todo.utils.BounceEdgeEffectFactory
import com.manpro.todo.utils.taskList
import com.manpro.todo.utils.taskListDelete

class TaskListFragment : BaseFragment<FragmentTaskListBinding>(FragmentTaskListBinding::inflate) {


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

        if (DetailTaskActivity.isDeleted) {
            rvAdapter.submitList(taskListDelete)
        } else {
            rvAdapter.submitList(taskList)
        }

        binding.textInputLayout4.editText?.addTextChangedListener { keyword ->
            val filteredList =
                taskList.filter { it.title.lowercase().contains(keyword.toString().lowercase()) }

            rvAdapter.submitList(filteredList)
        }

//        val taskMain = parentFragment as? TaskMainFragment
//        taskMain?.binding?.swipeContainer?.isRefreshing = false

    }


}