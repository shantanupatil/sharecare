package `in`.shantanupatil.sharecare.modules.interfaces

import `in`.shantanupatil.sharecare.modules.viewmodels.MainViewModel
import com.bumptech.glide.RequestManager

/**
 * Handles calls from fragments inside main activity.
 */
interface IFragmentCallsMA {
    /**
     * Changes the title of toolbar.
     */
    fun title(title: String)

    /**
     * Returns mainViewModel.
     */
    fun getViewModel(): MainViewModel

    /**
     * Returns request manager.
     */
    fun getRequestManager_(): RequestManager

    /**
     * Should show toolbar icon.
     */
    fun setToolbarIconVisibility(shouldShow: Boolean)
}