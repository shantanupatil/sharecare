package `in`.shantanupatil.sharecare.modules.routine.model

import `in`.shantanupatil.sharecare.modules.utils.ApplicationUtils
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "daily_routines", indices = [Index(value = ["timestamp"])])
class DailyRoutines (
    val routines: List<Routine>,
    val timestamp: Long = ApplicationUtils.getStartOfTheDayTimestamp(),
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0
)