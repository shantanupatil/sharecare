package `in`.shantanupatil.sharecare.modules.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import java.util.*

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

        /**
         * Returns the start of the day timestamp.
         */
        fun getStartOfTheDayTimestamp(): Long {
            val calendar = Calendar.getInstance()
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            return calendar.timeInMillis
        }
    }
}