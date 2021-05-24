package `in`.shantanupatil.sharecare.modules.viewmodels

import `in`.shantanupatil.sharecare.modules.repository.interfaces.IFirebaseDataRepository
import `in`.shantanupatil.sharecare.modules.repository.interfaces.ILocalDataRepository
import `in`.shantanupatil.sharecare.modules.routine.model.Routine
import `in`.shantanupatil.sharecare.modules.volunteer.model.Volunteer
import `in`.shantanupatil.sharecare.modules.volunteer.model.VolunteerCategory
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Main View model class.
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    val localDataRepository: ILocalDataRepository,
    val firebaseDataRepository: IFirebaseDataRepository
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
    fun addRoutine(title: String, timestamp: Long) = viewModelScope.launch {
        val routine = Routine(0, title, timestamp, false)
        localDataRepository.insert(routine)
    }


}