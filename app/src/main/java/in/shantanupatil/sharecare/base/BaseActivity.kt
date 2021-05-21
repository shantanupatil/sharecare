package `in`.shantanupatil.sharecare.base

import `in`.shantanupatil.sharecare.R
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

/**
 * BaseActivity for all activities which contains all the common code.
 */
abstract class BaseActivity : AppCompatActivity() {

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