package `in`.shantanupatil.sharecare.modules.volunteer.views

import `in`.shantanupatil.sharecare.R
import `in`.shantanupatil.sharecare.constants.NumericalConstants
import `in`.shantanupatil.sharecare.databinding.VolunteerCategoryItemBinding
import `in`.shantanupatil.sharecare.modules.volunteer.model.VolunteerCategory
import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.makeramen.roundedimageview.RoundedImageView


class VolunteerCategoryAdapter(
    val resources: Resources,
    private val requestManager: RequestManager
) :
    RecyclerView.Adapter<VolunteerCategoryAdapter.VolunteerCategoryHolder>() {

    /**
     * Holds width height of image.
     */
    private var widthHeight: Int = 0

    init {
        widthHeight = resources.getDimension(R.dimen.dimen_24).toInt()
    }

    private var volunteerCategories: List<VolunteerCategory> = listOf()

    inner class VolunteerCategoryHolder(private val binding: VolunteerCategoryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(volunteerCategory: VolunteerCategory) {
            binding.tvVolunteerCategoryName.text = volunteerCategory.title
            binding.tvVolunteerCategoryDescription.text = volunteerCategory.description
            if (volunteerCategory.images.isNotEmpty()) {
                for (index in volunteerCategory.images.indices) {
                    setImage(binding.root.context, index, volunteerCategory, binding)
                }
            }
        }
    }

    /**
     * Sets volunteer images data.
     */
    private fun setImage(
        context: Context,
        index: Int,
        volunteerCategory: VolunteerCategory,
        binding: VolunteerCategoryItemBinding
    ) {
        val image = RoundedImageView(context)
        image.isOval = true
        val layoutParams = LinearLayout.LayoutParams(widthHeight, widthHeight)
        image.scaleType = ImageView.ScaleType.CENTER_CROP
        image.layoutParams = layoutParams
        if (index >= NumericalConstants.NUMBER_ONE) {
            layoutParams.setMargins(
                NumericalConstants.MINUS_TEN,
                NumericalConstants.NUMBER_ZERO,
                NumericalConstants.NUMBER_ZERO,
                NumericalConstants.NUMBER_ZERO
            )
           image.layoutParams =
                layoutParams
        }
        requestManager.load(volunteerCategory.images[index])
            .placeholder(R.drawable.circle_placeholder)
            .into(image)
        binding.clImagesContainer.addView(image)
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