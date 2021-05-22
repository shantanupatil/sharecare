package `in`.shantanupatil.sharecare.modules.volunteer.views.activities

import `in`.shantanupatil.sharecare.base.BaseActivity
import `in`.shantanupatil.sharecare.constants.StringConstants
import `in`.shantanupatil.sharecare.databinding.ActivityVolunteerListBinding
import `in`.shantanupatil.sharecare.modules.volunteer.model.VolunteerCategory
import `in`.shantanupatil.sharecare.modules.volunteer.views.adapters.VolunteerListAdapter
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager

/**
 * Holds list of volunteers.
 */
class VolunteerListActivity : BaseActivity() {

    private lateinit var binding: ActivityVolunteerListBinding
    private lateinit var volunteerListAdapter: VolunteerListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityVolunteerListBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)

        setRecyclerView()

        getIntentAndLoadData()

        binding.ivBackButton.setOnClickListener {
            finish()
        }

    }

    private fun setRecyclerView() {
        volunteerListAdapter = VolunteerListAdapter(requestManager)
        binding.rvVolunteerList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@VolunteerListActivity)
            adapter = volunteerListAdapter
        }
    }

    /**
     * Gets the volunteer category object from intent and loads data.
     */
    private fun getIntentAndLoadData() {
        val volunteerCategory =
            intent.getSerializableExtra(StringConstants.VOLUNTEER_CATEGORY_OBJECT) as VolunteerCategory
        mainViewModel.loadVolunteers(volunteerCategory.id) { volunteers ->
            hideProgressbar()
            if(volunteers.isNotEmpty()) {
                volunteerListAdapter.submitList(volunteers)
            } else {
                binding.tvError.visibility = View.VISIBLE
            }
        }
    }

    private fun hideProgressbar() {
        binding.icProgress.pbProgress.visibility = View.GONE
    }

    override fun getView(): View {
        return binding.root
    }
}