package com.manpro.todo.ui.detail.task.reminder

import android.app.TimePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import com.manpro.todo.R
import android.text.format.DateFormat
import android.view.WindowManager
import com.manpro.todo.databinding.FragmentReminderBinding
import java.util.*

class ReminderFragment : DialogFragment() {

    private lateinit var binding: FragmentReminderBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentReminderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        val layoutParams = dialog?.window?.attributes
        layoutParams?.width = WindowManager.LayoutParams.MATCH_PARENT
        dialog?.window?.attributes = layoutParams
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)
        val is24Hour = DateFormat.is24HourFormat(context)

        binding.btnOpenTimePicker.setOnClickListener {

            TimePickerDialog(
                context,
                 { _, hour, minute ->

                    val selectedTime = "$hour.$minute"

                    binding.etReminder.editText?.setText(selectedTime)

                }, hour, minute, is24Hour
            ).show()

        }

        binding.btnSelesai.setOnClickListener {
            //do insert

            dismiss()
        }

        binding.btnBatal.setOnClickListener {
            dismiss()
        }


    }


}