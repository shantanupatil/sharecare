package `in`.shantanupatil.sharecare.modules.repository.interfaces

import `in`.shantanupatil.sharecare.modules.volunteer.model.Volunteer
import `in`.shantanupatil.sharecare.modules.volunteer.model.VolunteerCategory

interface IFirebaseDataRepository {

    /**
     * Loads volunteers data
     */
    fun loadVolunteers(id: String, listener: (List<Volunteer>) -> Unit)

    /**
     * Loads volunteer categories.
     */
    fun loadVolunteerCategories(listener: (List<VolunteerCategory>) -> Unit)
}