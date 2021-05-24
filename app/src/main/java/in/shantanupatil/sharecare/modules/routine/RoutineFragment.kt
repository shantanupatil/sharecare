package `in`.shantanupatil.sharecare.modules.routine

import `in`.shantanupatil.sharecare.R
import `in`.shantanupatil.sharecare.base.BaseFragment
import `in`.shantanupatil.sharecare.databinding.FragmentRoutineBinding
import `in`.shantanupatil.sharecare.modules.routine.views.DailyRoutineAdapter
import `in`.shantanupatil.sharecare.modules.utils.ApplicationUtils
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

/**
 * Holds data for Routine Fragment.
 */
class RoutineFragment : BaseFragment() {

    private lateinit var binding: FragmentRoutineBinding

    /**
     * Holds daily routine Adapter.
     */
    private lateinit var dailyRoutineAdapter: DailyRoutineAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle(getString(R.string.routine))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRoutineBinding.bind(view)

        setIconVisibility(true)

        setRecyclerView()

        loadRoutineData()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_routine, container, false)
    }

    /**
     * Sets the recyclerview.
     */
    private fun setRecyclerView() {
        dailyRoutineAdapter = DailyRoutineAdapter()
        binding.rvDailyRoutine.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
            adapter = dailyRoutineAdapter
        }

        dailyRoutineAdapter.setOnItemClickListener { dailyRoutines ->
            mainViewModel.update(dailyRoutines)
        }
    }

    /**
     * Loads the routine data from database.
     */
    private fun loadRoutineData() {
        mainViewModel.loadRoutinesDataFromDatabase()
            .observe(viewLifecycleOwner, Observer { response ->
                response?.let { dailyRoutine ->
                    hideProgressbar(binding.pbProgress)
                    if (dailyRoutine.isEmpty()) {
                        // Checks if the millis are set, if it is not -1 then the database do have
                        // entries for the selected date.
                        if (ApplicationUtils.getTimeInMillis() == (-1).toLong()) {
                            binding.tvError.text = getString(R.string.no_routines)
                            mainViewModel.addRoutinesToDatabase()
                        } else {
                            binding.tvError.text = getString(R.string.no_routines_for_the_date)
                            ApplicationUtils.setTimeInMillis(-1, -1, -1)
                        }
                    } else {
                        binding.tvError.visibility = View.GONE
                        dailyRoutineAdapter.submitList(dailyRoutine[0])
                    }
                }
            })
    }
}