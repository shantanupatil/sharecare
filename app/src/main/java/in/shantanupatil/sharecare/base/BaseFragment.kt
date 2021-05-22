package `in`.shantanupatil.sharecare.base

import `in`.shantanupatil.sharecare.MainActivity
import `in`.shantanupatil.sharecare.R
import `in`.shantanupatil.sharecare.modules.interfaces.IFragmentCallsMA
import `in`.shantanupatil.sharecare.modules.viewmodels.MainViewModel
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.RequestManager
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

/**
 * BaseFragment for holding all the common methods.
 */
@AndroidEntryPoint
open class BaseFragment : Fragment() {

    @Inject
    lateinit var requestManager: RequestManager

    val mainViewModel: MainViewModel by viewModels()

    private var activityListener: IFragmentCallsMA? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        activityListener = context as MainActivity
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    /**
     * Hides progressbar.
     */
    fun hideProgressbar(pbProgress: ProgressBar) {
        pbProgress.visibility = View.GONE
    }

    /**
     * Sets the title.
     */
    fun setTitle(title: String) {
        activityListener?.title(title)

    }
}