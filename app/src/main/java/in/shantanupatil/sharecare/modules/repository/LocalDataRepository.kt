package `in`.shantanupatil.sharecare.modules.repository

import `in`.shantanupatil.sharecare.db.ShareCareDatabase
import `in`.shantanupatil.sharecare.modules.repository.interfaces.ILocalDataRepository
import `in`.shantanupatil.sharecare.modules.routine.model.DailyRoutines
import `in`.shantanupatil.sharecare.modules.routine.model.Routine

class LocalDataRepository :
    ILocalDataRepository {

    override suspend fun insert(routine: Routine) {
        ShareCareDatabase.getInstance().getDao().insert(routine)
    }

    override suspend fun insert(dailyRoutines: DailyRoutines) = ShareCareDatabase.getInstance().getDao()
        .insert(dailyRoutines)

    override fun getRoutinesForToday(startOfTheDayTimestamp: Long) =
        ShareCareDatabase.getInstance().getDao().getRoutinesForToday(startOfTheDayTimestamp)

    override suspend fun getRoutines() = ShareCareDatabase.getInstance().getDao().getRoutines()

    override suspend fun update(dailyRoutines: DailyRoutines) = ShareCareDatabase.getInstance().getDao().update(dailyRoutines)
}