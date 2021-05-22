package `in`.shantanupatil.sharecare.modules.interfaces

/**
 * Handles calls from fragments inside main activity.
 */
interface IFragmentCallsMA {
    /**
     * Changes the title of toolbar.
     */
    fun title(title: String)
}