package `in`.shantanupatil.sharecare.modules.viewmodels

import `in`.shantanupatil.sharecare.modules.repository.interfaces.IFirebaseDataRepository
import `in`.shantanupatil.sharecare.modules.repository.interfaces.ILocalDataRepository
import `in`.shantanupatil.sharecare.modules.volunteer.model.VolunteerCategory
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
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


}