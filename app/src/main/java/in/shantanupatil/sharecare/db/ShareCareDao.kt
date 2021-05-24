package `in`.shantanupatil.sharecare.db

import `in`.shantanupatil.sharecare.modules.routine.model.DailyRoutines
import `in`.shantanupatil.sharecare.modules.routine.model.Routine
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ShareCareDao {

    /**
     * Inserts the routine.
     */
    @Insert
    suspend fun insert(routine: Routine)

    /**
     * Inserts the daily routine in database.
     */
    @Insert
    suspend fun insert(dailyRoutines: DailyRoutines)

    /**
     * Gets daily routine from database.
     */
    @Query("SELECT * FROM daily_routines WHERE timestamp = :timestamp")
    fun getRoutinesForToday(timestamp: Long): LiveData<List<DailyRoutines>>

    /**
     * Gets all routines from database.
     */
    @Query("SELECT * FROM routine_table")
    suspend fun getRoutines(): List<Routine>
}