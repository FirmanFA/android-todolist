package com.manpro.todo.ui.main.content.task

import android.app.AlertDialog
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayoutMediator
import com.manpro.todo.R
import com.manpro.todo.databinding.FragmentTaskMainBinding
import com.manpro.todo.ui.base.BaseFragment
import kotlin.system.exitProcess

class TaskMainFragment : BaseFragment<FragmentTaskMainBinding>(FragmentTaskMainBinding::inflate) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val vpAdapter = TaskViewPagerAdapter(this)
        binding.vpTaskList.apply {
            adapter = vpAdapter
            (getChildAt(0) as RecyclerView).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        }


        binding.swipeContainer.setOnRefreshListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                parentFragmentManager.beginTransaction().detach(this).commitNow();
                parentFragmentManager.beginTransaction().attach(this).commitNow();
            } else {
                parentFragmentManager.beginTransaction().detach(this).attach(this).commit();
            }

            binding.swipeContainer.isRefreshing = false

        }

        binding.imageView5.setOnClickListener {
            AlertDialog.Builder(context).apply {
                setTitle("Logout")
                setMessage("Are you sure want to logout?")
                setPositiveButton("Logout") { dialog, _ ->

                    //do delete

                    dialog.dismiss()
                    activity?.finishAffinity()
                    exitProcess(0)

                }
                setNegativeButton("Cancel"){dialog, _ ->
                    dialog.dismiss()
                }

                create()
                show()
            }
        }



        TabLayoutMediator(binding.tabLayout, binding.vpTaskList) { tab, pos ->
            when (pos) {
                0 -> {
                    tab.text = "Today"
                }
                1 -> {
                    tab.text = "Task List"
                }
            }
        }.attach()

    }

}