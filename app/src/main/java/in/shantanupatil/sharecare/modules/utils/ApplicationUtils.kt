package `in`.shantanupatil.sharecare.modules.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import java.util.*

class ApplicationUtils {
    companion object {

        /**
         * Holds timestamp to load routines for a specific date.
         */
        private var timeInMillis: Long = -1

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

        /**
         * Returns a date in format Mon Jan 21.
         */
        fun getDate(timestamp: Long): String {
            val date = Date(timestamp).toString()
            val splittedDate = date.split(" ")
            return "${splittedDate[0]} ${splittedDate[1]} ${splittedDate[2]}"
        }

        /**
         * Sets the timestamp for showing selected date routines.
         */
        fun setTimeInMillis(year: Int, month: Int, dayOfMonth: Int) {
            val calendar = Calendar.getInstance()
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, month)
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            calendar.set(Calendar.HOUR_OF_DAY, 0)
            calendar.set(Calendar.MINUTE, 0)
            calendar.set(Calendar.SECOND, 0)
            calendar.set(Calendar.MILLISECOND, 0)
            if (year != -1) {
                this.timeInMillis = calendar.timeInMillis
            } else {
                this.timeInMillis = -1
            }
        }

        /**
         * Returns the timestamp for showing selected date routines.
         */
        fun getTimeInMillis(): Long {
            return timeInMillis
        }
    }
}