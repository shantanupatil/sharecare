package `in`.shantanupatil.sharecare.modules.repository

import `in`.shantanupatil.sharecare.db.ShareCareDatabase
import `in`.shantanupatil.sharecare.modules.repository.interfaces.ILocalDataRepository
import `in`.shantanupatil.sharecare.modules.routine.model.Routine

class LocalDataRepository:
    ILocalDataRepository {

    override suspend fun insert(routine: Routine) {
        ShareCareDatabase.getInstance().getDao().insert(routine)
    }
}