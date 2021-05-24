package `in`.shantanupatil.sharecare.modules.viewmodels

import `in`.shantanupatil.sharecare.modules.Resource
import `in`.shantanupatil.sharecare.modules.repository.interfaces.IFirebaseDataRepository
import `in`.shantanupatil.sharecare.modules.repository.interfaces.ILocalDataRepository
import `in`.shantanupatil.sharecare.modules.routine.model.DailyRoutines
import `in`.shantanupatil.sharecare.modules.routine.model.Routine
import `in`.shantanupatil.sharecare.modules.utils.ApplicationUtils
import `in`.shantanupatil.sharecare.modules.volunteer.model.Volunteer
import `in`.shantanupatil.sharecare.modules.volunteer.model.VolunteerCategory
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

/**
 * Main View model class.
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val localDataRepository: ILocalDataRepository,
    private val firebaseDataRepository: IFirebaseDataRepository
) : ViewModel() {

    /**
     * Loads data from firebase repository for firebase.
     */
    fun loadVolunteerCategories(listener: (List<VolunteerCategory>) -> Unit) {
        firebaseDataRepository.loadVolunteerCategories(listener)
    }

    /**
     * Loads volunteer data from id.
     */
    fun loadVolunteers(id: String, listener: (List<Volunteer>) -> Unit) {
        firebaseDataRepository.loadVolunteers(id, listener)
    }

    /**
     * Adds the routine to database.
     */
    fun addRoutine(routine: Routine) = viewModelScope.launch {
        localDataRepository.insert(routine)

    }

    /**
     * Adds the routine to todays routine
     */
    private fun addToDailyRoutine(routine: Routine) {
        localDataRepository.getRoutinesForToday(ApplicationUtils.getStartOfTheDayTimestamp())
    }

    fun loadRoutinesDataFromDatabase() = localDataRepository.getRoutinesForToday(ApplicationUtils.getStartOfTheDayTimestamp())

    /**
     * Adds routines to database.
     */
    fun addRoutinesToDatabase() = viewModelScope.launch {
        val routines = localDataRepository.getRoutines()
        if (routines.isNotEmpty()) {
            val dailyRoutine = DailyRoutines(routines, ApplicationUtils.getStartOfTheDayTimestamp())
            localDataRepository.insert(dailyRoutine)
        }
    }

    /**
     * Updates the daily routine.
     */
    fun update(dailyRoutines: DailyRoutines) = viewModelScope.launch {
        localDataRepository.update(dailyRoutines)
    }
}