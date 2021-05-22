package `in`.shantanupatil.sharecare.modules.volunteer.views

import `in`.shantanupatil.sharecare.databinding.VolunteerCategoryItemBinding
import `in`.shantanupatil.sharecare.modules.volunteer.model.VolunteerCategory
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class VolunteerCategoryAdapter :
    RecyclerView.Adapter<VolunteerCategoryAdapter.VolunteerCategoryHolder>() {

    private var volunteerCategories: List<VolunteerCategory> = listOf()

    inner class VolunteerCategoryHolder(val binding: VolunteerCategoryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(volunteerCategory: VolunteerCategory) {
            binding.tvVolunteerCategoryName.text = volunteerCategory.title
            binding.tvVolunteerCategoryDescription.text = volunteerCategory.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VolunteerCategoryHolder {
        return VolunteerCategoryHolder(
            VolunteerCategoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return volunteerCategories.size
    }

    override fun onBindViewHolder(holder: VolunteerCategoryHolder, position: Int) {
        holder.bind(volunteerCategories[position])
    }

    fun submitList(volunteerCategories: List<VolunteerCategory>) {
        this.volunteerCategories = volunteerCategories
        // As there will be limited categories, using notifyDataSetChanged can be sufficient
        // Note than in cases when you are loading large amount of data and have pagination
        // Please use notifyItemRangeChanged()
        notifyDataSetChanged()
    }
}