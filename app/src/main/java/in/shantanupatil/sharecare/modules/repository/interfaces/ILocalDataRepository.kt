package `in`.shantanupatil.sharecare.modules.repository.interfaces

import `in`.shantanupatil.sharecare.modules.routine.model.DailyRoutines
import `in`.shantanupatil.sharecare.modules.routine.model.Routine
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface ILocalDataRepository {

    /**
     * Inserts the routine.
     */
    suspend fun insert(routine: Routine)

    /**
     * Inserts the daily routine.
     */
    suspend fun insert(dailyRoutines: DailyRoutines)

    /**
     * Gets the routines for today.
     */
    fun getRoutinesForToday(startOfTheDayTimestamp: Long): LiveData<List<DailyRoutines>>

    /**
     * Gets all routines from database.
     */
    suspend fun getRoutines(): List<Routine>

    /**
     * Updates the daily routine.
     */
    suspend fun update(dailyRoutines: DailyRoutines)
}