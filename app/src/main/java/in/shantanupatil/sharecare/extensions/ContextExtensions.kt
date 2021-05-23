package `in`.shantanupatil.sharecare.extensions

import `in`.shantanupatil.sharecare.constants.StringConstants
import android.content.Context
import android.util.Log
import android.widget.Toast

fun Context.logError(className: String, message: String) {
    Log.e(StringConstants.ERROR_TAG, "$className $message")
}

fun Context.logInfo(className: String, message: String) {
    Log.i(StringConstants.INFO_TAG, "$className $message")
}

fun Context.showToast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}