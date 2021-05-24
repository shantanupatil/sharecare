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

    val routines: MutableLiveData<Resource<DailyRoutines>> = MutableLiveData()

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
    fun addRoutine(title: String, timestamp: Long) = viewModelScope.launch {
        val routine = Routine(0, title, timestamp, false)
        localDataRepository.insert(routine)
    }

    fun loadRoutinesDataFromDatabase() {
        routines.postValue(Resource.Loading())
        try {
            val response = localDataRepository.getRoutinesForToday(ApplicationUtils.getStartOfTheDayTimestamp())
            val routinesList = response.value
            routinesList?.let {
                routines.postValue(Resource.Success(it[0]))
            } ?: kotlin.run {
                routines.postValue(Resource.Success(DailyRoutines(listOf())))
            }
        } catch (exception: Exception) {
            routines.postValue(Resource.Error("Something went wrong"))
        }
    }

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
}