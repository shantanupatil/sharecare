package `in`.shantanupatil.sharecare.modules.repository

import `in`.shantanupatil.sharecare.constants.NumericalConstants
import `in`.shantanupatil.sharecare.modules.repository.interfaces.IFirebaseDataRepository
import `in`.shantanupatil.sharecare.modules.volunteer.model.Volunteer
import `in`.shantanupatil.sharecare.modules.volunteer.model.VolunteerCategory
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query

/**
 * Interacts with firebase to load and save data.
 */
class FirebaseDataRepository :
    IFirebaseDataRepository {

    private var firebaseFirestore: FirebaseFirestore = FirebaseFirestore.getInstance()

    override fun loadVolunteers(id: String, listener: (List<Volunteer>) -> Unit) {
        firebaseFirestore.collection("volunteer")
            .whereEqualTo("typeId", id)
            .get()
            .addOnSuccessListener {
                val volunteers = ArrayList<Volunteer>()
                it.forEach { document ->
                    val volunteer = document.toObject(Volunteer::class.java)
                    volunteers.add(volunteer)
                }
                listener(volunteers)
            }.addOnFailureListener {
                listener(mutableListOf())
            }
    }

    override fun loadVolunteerCategories(listener: (List<VolunteerCategory>) -> Unit) {
        firebaseFirestore.collection("volunteer_categories")
            .orderBy("timestamp", Query.Direction.DESCENDING)
            .get()
            .addOnSuccessListener {
                val volunteerCategories = ArrayList<VolunteerCategory>()
                it.forEach { document ->
                    val volunteerCategory = document.toObject(VolunteerCategory::class.java)
                    volunteerCategories.add(volunteerCategory)
                }
                listener(volunteerCategories)
            }.addOnFailureListener {
                listener(mutableListOf())
            }
    }
}