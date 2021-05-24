package `in`.shantanupatil.sharecare.modules.routine

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import `in`.shantanupatil.sharecare.R
import `in`.shantanupatil.sharecare.base.BaseFragment
import `in`.shantanupatil.sharecare.databinding.FragmentRoutineBinding
import `in`.shantanupatil.sharecare.modules.Resource
import android.widget.ProgressBar
import androidx.lifecycle.Observer

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

        loadRoutineData()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_routine, container, false)
    }

    /**
     * Loads the routine data from database.
     */
    private fun loadRoutineData() {
        mainViewModel.loadRoutinesDataFromDatabase()
        observeResponse()
    }

    private fun observeResponse() {
        mainViewModel.routines.observe(viewLifecycleOwner, Observer { response ->
            when(response) {
                is Resource.Loading -> {
                    showProgressbar(binding.pbProgress)
                }

                is Resource.Success -> {
                    response.data?.let {
                        hideProgressbar(binding.pbProgress)
                        if (it.routines.isEmpty()) {
                            mainViewModel.addRoutinesToDatabase()
                        } else {

                        }
                    }
                }

                is Resource.Error -> {

                }
            }
        })
    }
}