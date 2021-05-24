package `in`.shantanupatil.sharecare.modules.routine.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "routine_table")
data class Routine(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val title: String,
    val timestamp: Long = 0,
    var isCompleted: Boolean
)