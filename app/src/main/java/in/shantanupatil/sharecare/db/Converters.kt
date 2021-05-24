package `in`.shantanupatil.sharecare.db

import `in`.shantanupatil.sharecare.modules.routine.model.Routine
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    @TypeConverter
    fun fromRoutines(routines: List<Routine>): String {
        val listType = object : TypeToken<List<Routine>>() {}.type
        return Gson().toJson(routines, listType)
    }

    @TypeConverter
    fun toRoutines(jsonRoutine: String): List<Routine> {
        val listType = object : TypeToken<List<Routine>>() {}.type
        return Gson().fromJson(jsonRoutine, listType)
    }
}