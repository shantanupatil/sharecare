package `in`.shantanupatil.sharecare.modules.home

import `in`.shantanupatil.sharecare.R
import `in`.shantanupatil.sharecare.base.BaseFragment
import `in`.shantanupatil.sharecare.databinding.FragmentHomeBinding
import `in`.shantanupatil.sharecare.modules.utils.ApplicationUtils
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * HomeFragment class.
 */
class HomeFragment : BaseFragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle(getString(R.string.home))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)

        setIconVisibility(false)

        setCalendarClickListeners()
    }

    private fun setCalendarClickListeners() {
        binding.cvHome.setOnDateChangeListener { view, year, month, dayOfMonth ->
            ApplicationUtils.setTimeInMillis(year, month, dayOfMonth)
            navigateToRoutines()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
}