package `in`.shantanupatil.sharecare.modules.volunteer.model

import java.io.Serializable

class Volunteer() : Serializable {
    var name: String = ""
    var description: String = ""
    var profileImage: String = ""
    var contactInformation: List<Long> = listOf()
}