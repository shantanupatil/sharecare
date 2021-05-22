package `in`.shantanupatil.sharecare

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ShareCareApplication: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}