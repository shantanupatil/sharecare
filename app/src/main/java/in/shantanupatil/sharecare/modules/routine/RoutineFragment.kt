package `in`.shantanupatil.sharecare.modules.routine

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import `in`.shantanupatil.sharecare.R
import `in`.shantanupatil.sharecare.base.BaseFragment
import `in`.shantanupatil.sharecare.databinding.FragmentRoutineBinding

/**
 * Holds data for Routine Fragment.
 */
class RoutineFragment : BaseFragment() {

    private lateinit var binding: FragmentRoutineBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle(getString(R.string.routine))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRoutineBinding.bind(view)

        setIconVisibility(true)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_routine, container, false)
    }
}