package `in`.shantanupatil.sharecare.modules.home.models

sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null
) {
    /**
     * Handles success.
     */
    class Success<T>(data: T) : Resource<T>(data)

    /**
     * Handles error.
     */
    class Error<T>(message: String) : Resource<T>(null, message)

    /**
     * Handles loading.
     */
    class Loading<T> : Resource<T>()
}