package `in`.shantanupatil.sharecare.modules.volunteer.views.fragments

import `in`.shantanupatil.sharecare.R
import `in`.shantanupatil.sharecare.base.BaseFragment
import `in`.shantanupatil.sharecare.constants.NumericalConstants
import `in`.shantanupatil.sharecare.constants.StringConstants
import `in`.shantanupatil.sharecare.databinding.FragmentVolunteerCategoryBinding
import `in`.shantanupatil.sharecare.modules.volunteer.views.activities.VolunteerListActivity
import `in`.shantanupatil.sharecare.modules.volunteer.views.adapters.VolunteerCategoryAdapter
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle(getString(R.string.volunteer_type))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentVolunteerCategoryBinding.bind(view)

        setIconVisibility(false)

        setRecyclerView()

        loadData()
    }

    /**
     * Sets the recyclerview.
     */
    private fun setRecyclerView() {
        volunteerCategoryAdapter =
            VolunteerCategoryAdapter(
                requireContext().resources,
                requestManager
            )
        binding.rvVolunteerCategories.apply {
            setHasFixedSize(true)
            layoutManager =
                StaggeredGridLayoutManager(
                    NumericalConstants.VOLUNTEER_CATEGORY_UI_COUNT,
                    LinearLayoutManager.VERTICAL
                )
            adapter = volunteerCategoryAdapter
        }

        // Handles the click
        volunteerCategoryAdapter.setOnVolunteerCategoryClicked { volunteerCategory ->
            Intent(requireContext(), VolunteerListActivity::class.java).apply {
                putExtra(StringConstants.VOLUNTEER_CATEGORY_OBJECT, volunteerCategory)
            }.also { intent ->
                startActivity(intent)
            }
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