package `in`.shantanupatil.sharecare.modules.volunteer

import `in`.shantanupatil.sharecare.R
import `in`.shantanupatil.sharecare.base.BaseFragment
import `in`.shantanupatil.sharecare.constants.NumericalConstants
import `in`.shantanupatil.sharecare.databinding.FragmentVolunteerCategoryBinding
import `in`.shantanupatil.sharecare.modules.volunteer.views.VolunteerCategoryAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager

/**
 * Holds volunteer category data.
 */
class VolunteerCategoryFragment : BaseFragment() {

    /**
     * Layout binding.
     */
    private lateinit var binding: FragmentVolunteerCategoryBinding

    /**
     * Holds volunteer category adapter.
     */
    private lateinit var volunteerCategoryAdapter: VolunteerCategoryAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentVolunteerCategoryBinding.bind(view)

        setRecyclerView()

        loadData()
    }

    /**
     * Sets the recyclerview.
     */
    private fun setRecyclerView() {
        volunteerCategoryAdapter = VolunteerCategoryAdapter()
        binding.rvVolunteerCategories.apply {
            setHasFixedSize(true)
            layoutManager =
                GridLayoutManager(requireContext(), NumericalConstants.VOLUNTEER_CATEGORY_UI_COUNT)
            adapter = volunteerCategoryAdapter
        }
    }

    /**
     * Loads volunteer category data from firebase.
     */
    private fun loadData() {
        mainViewModel.loadVolunteerCategories { volunteerCategories ->
            if (volunteerCategories.isEmpty()) {
                binding.tvError.visibility = View.VISIBLE
            } else {
                hideProgressbar(binding.icProgress.pbProgress)
                volunteerCategoryAdapter.submitList(volunteerCategories)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_volunteer_category, container, false)
    }
}