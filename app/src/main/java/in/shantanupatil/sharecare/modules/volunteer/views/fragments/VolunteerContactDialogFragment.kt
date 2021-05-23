package `in`.shantanupatil.sharecare.modules.volunteer.views.fragments

import `in`.shantanupatil.sharecare.R
import `in`.shantanupatil.sharecare.constants.StringConstants
import `in`.shantanupatil.sharecare.databinding.FragmentVolunteerContactDialogBinding
import `in`.shantanupatil.sharecare.extensions.showToast
import `in`.shantanupatil.sharecare.modules.utils.ApplicationUtils
import `in`.shantanupatil.sharecare.modules.volunteer.model.Volunteer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.RequestManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * Volunteer contact dialog fragment.
 */
@AndroidEntryPoint
class VolunteerContactDialogFragment : DialogFragment() {

    @Inject
    lateinit var requestManager: RequestManager

    /**
     * Creates new instance of VolunteerContactDialogFragment.
     */
    fun newInstance(volunteer: Volunteer): VolunteerContactDialogFragment {
        val volunteerContactDialogFragment = VolunteerContactDialogFragment()
        val bundle = Bundle()
        bundle.putSerializable(StringConstants.VOLUNTEER_OBJECT, volunteer)
        volunteerContactDialogFragment.arguments = bundle
        return volunteerContactDialogFragment
    }

    private lateinit var binding: FragmentVolunteerContactDialogBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentVolunteerContactDialogBinding.bind(view)

        setDataFromArgumentsBundle()

    }

    /**
     * Gets the bundle from arguments and sets data in view.
     */
    private fun setDataFromArgumentsBundle() {
        arguments?.let {
            val volunteer = it.getSerializable(StringConstants.VOLUNTEER_OBJECT) as Volunteer
            requestManager
                .load(volunteer.profileImage)
                .placeholder(R.drawable.circle_placeholder)
                .error(R.drawable.circle_placeholder)
                .into(binding.ivCVDThumb)
            binding.tvVCDName.text = volunteer.name
            binding.tvVCDDescription.text = volunteer.description

            // Set the contact textView click listener
            binding.tvContact.setOnClickListener {
                dialog?.cancel()
                if (volunteer.contactInformation.isNotEmpty()) {
                    ApplicationUtils.callNumber(requireContext(), volunteer.contactInformation[0])
                } else {
                    requireContext().showToast(requireContext(), getString(R.string.no_contact_information_found))
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_volunteer_contact_dialog, container, false)
    }

}