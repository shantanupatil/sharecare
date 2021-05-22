package `in`.shantanupatil.sharecare.base

import `in`.shantanupatil.sharecare.modules.viewmodels.MainViewModel
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

/**
 * BaseFragment for holding all the common methods.
 */
@AndroidEntryPoint
open class BaseFragment : Fragment() {

    val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    /**
     * Hides progressbar.
     */
    fun hideProgressbar(pbProgress: ProgressBar) {
        pbProgress.visibility = View.GONE
    }
}