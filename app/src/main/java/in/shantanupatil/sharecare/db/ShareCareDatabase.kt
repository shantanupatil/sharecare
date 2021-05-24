package `in`.shantanupatil.sharecare.db

import `in`.shantanupatil.sharecare.constants.StringConstants
import `in`.shantanupatil.sharecare.modules.routine.model.DailyRoutines
import `in`.shantanupatil.sharecare.modules.routine.model.Routine
import android.content.Context
import androidx.room.*

/**
 * Database class.
 */
@Database(entities = [Routine::class, DailyRoutines::class], version = 1)
@TypeConverters(Converters::class)
abstract class ShareCareDatabase : RoomDatabase() {

    /**
     * Returns dao.
     */
    abstract fun getDao(): ShareCareDao

    companion object {

        private var instance: ShareCareDatabase? = null

        @Synchronized
        fun invoke(context: Context) {
            instance ?: createDatabase(context).also {
                instance = it
            }
        }

        private fun createDatabase(context: Context): ShareCareDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                ShareCareDatabase::class.java,
                StringConstants.DATABASE_NAME
            )
                .fallbackToDestructiveMigration()
                .build()
        }

        @Synchronized
        fun getInstance(): ShareCareDatabase {
            return instance!!
        }

    }
}