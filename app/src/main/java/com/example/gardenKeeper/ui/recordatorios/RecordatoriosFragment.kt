package com.example.gardenkeeper.ui.recordatorios

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.gardenkeeper.R
import java.util.Calendar

class RecordatoriosFragment : Fragment() {

    // ... other code ...

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnOpenCalendar = view.findViewById<Button>(R.id.btnOpenCalendar)
        val etNote = view.findViewById<EditText>(R.id.etNote)
        val tvReminder = view.findViewById<TextView>(R.id.tvReminder)
        val remindersContainer = view.findViewById<LinearLayout>(R.id.remindersContainer)

        btnOpenCalendar.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                requireContext(),
                { _, selectedYear, selectedMonth, selectedDayOfMonth ->
                    val selectedDate = "$selectedDayOfMonth/${selectedMonth + 1}/$selectedYear"
                    val note = etNote.text.toString()
                    val reminderText = "$selectedDate - $note"

                    // Display the reminder in tvReminder
                    //tvReminder.text = reminderText

                    // Create a new TextView for the reminder and add it to the container
                    val reminderTextView = TextView(requireContext())
                    reminderTextView.text = reminderText
                    reminderTextView.setPadding(8, 8, 8, 8)
                    remindersContainer.addView(reminderTextView)
                },
                year,
                month,
                day
            )
            datePickerDialog.show()
        }
    }
}