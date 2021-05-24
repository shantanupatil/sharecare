package `in`.shantanupatil.sharecare.modules.repository.interfaces

import `in`.shantanupatil.sharecare.modules.routine.model.Routine

interface ILocalDataRepository {

    /**
     * Inserts the routine.
     */
    suspend fun insert(routine: Routine)
}