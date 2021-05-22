package `in`.shantanupatil.sharecare.base

import `in`.shantanupatil.sharecare.R
import `in`.shantanupatil.sharecare.modules.viewmodels.MainViewModel
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.RequestManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * BaseActivity for all activities which contains all the common code.
 */
@AndroidEntryPoint
abstract class BaseActivity : AppCompatActivity() {

    // Request manager to load images
    @Inject
    lateinit var requestManager: RequestManager

    // MainViewModel
    val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getView())
        setStatusBarColor()
    }

    /**
     * Changes status bar color.
     */
    private fun setStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        }
    }

    abstract fun getView(): View
}