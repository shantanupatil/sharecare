package `in`.shantanupatil.sharecare.modules.utils

import android.content.Context
import android.content.Intent
import android.net.Uri

class ApplicationUtils {
    companion object {

        /**
         * Opens the android dial pad with number.
         */
        fun callNumber(context: Context, number: Long) {
            Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:$number")
            }.also { intent ->
                context.startActivity(intent)
            }
        }
    }
}