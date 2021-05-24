package `in`.shantanupatil.sharecare

import `in`.shantanupatil.sharecare.db.ShareCareDatabase
import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * The application class.
 */
@HiltAndroidApp
class ShareCareApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // Create or initialize the database
        ShareCareDatabase.invoke(this)
    }
}