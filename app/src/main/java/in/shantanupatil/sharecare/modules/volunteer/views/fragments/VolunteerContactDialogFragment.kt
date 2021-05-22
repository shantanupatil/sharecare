package `in`.shantanupatil.sharecare.modules.volunteer.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import `in`.shantanupatil.sharecare.R
import androidx.fragment.app.DialogFragment

/**
 * Volunteer contact dialog fragment.
 */
class VolunteerContactDialogFragment : DialogFragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_volunteer_contact_dialog, container, false)
    }

}