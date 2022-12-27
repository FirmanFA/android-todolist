package com.manpro.todo.ui.main.content.task

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class TaskViewPagerAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> {
                TaskTodayFragment()
            }
            1 -> {
                TaskListFragment()
            }
            else ->{
                TaskTodayFragment()
            }
        }
    }

}