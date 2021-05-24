package `in`.shantanupatil.sharecare.modules.routine

import `in`.shantanupatil.sharecare.R
import `in`.shantanupatil.sharecare.base.BaseActivity
import `in`.shantanupatil.sharecare.databinding.ActivityAddRoutineBinding
import `in`.shantanupatil.sharecare.extensions.showToast
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.Toast
import java.util.*

/**
 * Add Routine Activity class.
 */
class AddRoutineActivity : BaseActivity() {

    private lateinit var binding: ActivityAddRoutineBinding
    private var timestamp: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAddRoutineBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)

        setDateTimepickerDialog()

        binding.tvSubmit.setOnClickListener {
            handleSubmission()
        }

    }

    private fun handleSubmission() {
        val title = binding.etTitle.text.toString()
        if (title.isNotEmpty() && timestamp.toInt() != 0) {
            mainViewModel.addRoutine(title, timestamp)
            showToast(this, getString(R.string.routine_added))
            finish()
        } else {
            showToast(this, getString(R.string.all_fields_required))
        }
    }

    private fun setDateTimepickerDialog() {
        binding.etDate.setOnClickListener {
            val calendar = Calendar.getInstance()
            val timePickerDialog = TimePickerDialog(this,
                TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                    calendar.set(Calendar.HOUR_OF_DAY, hourOfDay)
                    calendar.set(Calendar.MINUTE, minute)
                    timestamp = calendar.timeInMillis
                    binding.etDate.setText(Date(timestamp).toString())
                },
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),
                true
            )
            timePickerDialog.show()
        }
    }

    override fun getView(): View {
        return binding.root
    }
}