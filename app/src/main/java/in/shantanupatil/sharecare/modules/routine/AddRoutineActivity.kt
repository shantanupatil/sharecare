package `in`.shantanupatil.sharecare.modules.routine

import `in`.shantanupatil.sharecare.base.BaseActivity
import `in`.shantanupatil.sharecare.databinding.ActivityAddRoutineBinding
import android.os.Bundle
import android.view.View

/**
 * Add Routine Activity class.
 */
class AddRoutineActivity : BaseActivity() {

    private lateinit var binding: ActivityAddRoutineBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAddRoutineBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
    }

    override fun getView(): View {
        return binding.root
    }
}