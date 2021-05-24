package `in`.shantanupatil.sharecare.db

import `in`.shantanupatil.sharecare.modules.routine.model.Routine
import androidx.room.Dao
import androidx.room.Insert

@Dao
interface ShareCareDao {

    @Insert
    suspend fun insert(routine: Routine)
}