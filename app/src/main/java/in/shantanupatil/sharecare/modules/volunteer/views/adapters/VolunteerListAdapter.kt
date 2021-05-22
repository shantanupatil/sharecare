package `in`.shantanupatil.sharecare.modules.volunteer.views.adapters

import `in`.shantanupatil.sharecare.R
import `in`.shantanupatil.sharecare.databinding.VolunteerItemBinding
import `in`.shantanupatil.sharecare.modules.volunteer.model.Volunteer
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager

/**
 * Volunteer list adapter.
 */
class VolunteerListAdapter(val requestManager: RequestManager) :
    RecyclerView.Adapter<VolunteerListAdapter.VolunteerHolder>() {

    private var volunteers: List<Volunteer> = listOf()

    /**
     * Hold click listener for volunteers.
     */
    private var onItemClick: ((Volunteer) -> Unit)? = null

    /**
     * Updates the list and notifies it's changes.
     */
    fun submitList(volunteerList: List<Volunteer>) {
        volunteers = volunteerList
        notifyDataSetChanged()
    }

    inner class VolunteerHolder(val binding: VolunteerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(volunteer: Volunteer) {
            binding.tvVolunteerName.text = volunteer.name
            binding.tvVolunteerDescription.text = volunteer.description
            requestManager
                .load(volunteer.profileImage)
                .placeholder(R.drawable.circle_placeholder)
                .into(binding.ivVolunteerThumb)

            binding.root.setOnClickListener {
                onItemClick?.let {onClick ->
                    onClick(volunteer)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VolunteerHolder {
        return VolunteerHolder(
            VolunteerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return volunteers.size
    }

    override fun onBindViewHolder(holder: VolunteerHolder, position: Int) {
        holder.bind(volunteers[position])
    }

    /**
     * Sets the click listener for volunteer click.
     */
    fun setOnVolunteerClickedListener(listener: ((Volunteer) -> Unit)) {
        onItemClick = listener
    }
}