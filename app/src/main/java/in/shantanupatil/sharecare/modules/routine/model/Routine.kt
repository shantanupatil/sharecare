package `in`.shantanupatil.sharecare.modules.routine.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "routine_table")
data class Routine(
    @PrimaryKey
    val id: Long,
    val title: String,
    val isCompleted: Boolean
)