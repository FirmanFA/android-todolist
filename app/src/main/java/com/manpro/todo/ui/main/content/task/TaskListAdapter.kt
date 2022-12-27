package com.manpro.todo.ui.main.content.task

import android.graphics.Color
import android.graphics.ColorFilter
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.manpro.todo.data.api.model.task.DummyTask
import com.manpro.todo.databinding.TaskListLayoutBinding

class TaskListAdapter(private val onClick: (DummyTask) -> Unit) :
    ListAdapter<DummyTask, TaskListAdapter.ViewHolder>(DummyTaskCompatator()) {


    class ViewHolder(private val binding: TaskListLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            currentDummyTask: DummyTask,
            onClick: (DummyTask) -> Unit
        ) {
            binding.root.setOnClickListener {
                onClick(currentDummyTask)
            }

            binding.tvTaskTitle.text = currentDummyTask.title

            if (currentDummyTask.label == "#158700"){
                binding.tvTaskTitle.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            }

            binding.tvTaskDate.text = currentDummyTask.date
            binding.imageView7.setColorFilter(Color.parseColor(currentDummyTask.label))

        }

    }

    class DummyTaskCompatator : DiffUtil.ItemCallback<DummyTask>() {
        override fun areItemsTheSame(
            oldItem: DummyTask,
            newItem: DummyTask
        ): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(
            oldItem: DummyTask,
            newItem: DummyTask
        ): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = TaskListLayoutBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), onClick)
    }

}