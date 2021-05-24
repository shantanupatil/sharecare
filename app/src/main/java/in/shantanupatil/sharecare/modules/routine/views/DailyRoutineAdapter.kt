package `in`.shantanupatil.sharecare.modules.routine.views

import `in`.shantanupatil.sharecare.R
import `in`.shantanupatil.sharecare.databinding.DailyRoutineItemBinding
import `in`.shantanupatil.sharecare.modules.routine.model.DailyRoutines
import `in`.shantanupatil.sharecare.modules.routine.model.Routine
import `in`.shantanupatil.sharecare.modules.utils.ApplicationUtils
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

/**
 * The daily routine adapter for showing daily routines.
 */
class DailyRoutineAdapter : RecyclerView.Adapter<DailyRoutineAdapter.DailyRoutineHolder>() {

    /**
     * Holds routines.
     */
    private var routines: List<Routine> = listOf()

    /**
     * Holds daily routine.
     */
    private var dailyRoutines: DailyRoutines? = null

    private var onClickListener: ((DailyRoutines) -> Unit)? = null

    /**
     * Replaces the list and notifies about data change.
     */
    fun submitList(dailyRoutines: DailyRoutines) {
        this.dailyRoutines = dailyRoutines
        routines = dailyRoutines.routines
        notifyDataSetChanged()
    }

    inner class DailyRoutineHolder(val binding: DailyRoutineItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(routine: Routine) {
            binding.tvDailyRoutineTitle.text = routine.title.trim()
            binding.tvDailyRoutineDate.text = ApplicationUtils.getDate(routine.timestamp)
            if (routine.isCompleted) {
                binding.tvIsCompleted.text = binding.root.context.getString(R.string.completed)
                binding.tvIsCompleted.setTextColor(
                    ContextCompat.getColor(
                        binding.root.context,
                        R.color.colorPrimary
                    )
                )
            } else {
                binding.tvIsCompleted.text = binding.root.context.getString(R.string.not_completed)
                binding.tvIsCompleted.setTextColor(
                    ContextCompat.getColor(
                        binding.root.context,
                        R.color.red
                    )
                )
            }

            binding.root.setOnClickListener {
                onClickListener?.let { onClick ->
                    val position = dailyRoutines?.routines?.indexOf(routine) ?: -1
                    if (position != -1) {
                        (dailyRoutines?.routines as ArrayList).removeAt(position)
                        routine.isCompleted = !routine.isCompleted
                        (dailyRoutines?.routines as ArrayList).add(position, routine)
                        dailyRoutines?.let {
                            onClick(it)
                        }
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DailyRoutineHolder {
        return DailyRoutineHolder(
            DailyRoutineItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return routines.size
    }

    override fun onBindViewHolder(holder: DailyRoutineHolder, position: Int) {
        holder.bind(routines[position])
    }

    /**
     * Sets the daily routine click listener.
     */
    fun setOnItemClickListener(listener: (DailyRoutines) -> Unit) {
        onClickListener = listener
    }

}