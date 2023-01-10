package tv.mycujoo.mclscore.helper

import java.text.SimpleDateFormat
import java.util.*

/**
 * Helps in printing Date in human friendly format
 */
class DateTimeHelper {

    companion object {
        private const val DATE_FORMAT = "dd-MM-yyyy '-' HH:mm"

        /**
         * convert dateTime to formatted string like: '10-08-2021 - 18:00'
         * @param input dateTime
         */
        fun formatDatetime(input: Calendar, locale: Locale?): String? {
            return try {
                val sdf = if (locale != null) {
                    SimpleDateFormat(DATE_FORMAT, locale)
                } else {
                    SimpleDateFormat.getDateTimeInstance()
                }

                return sdf.format(input.time)
            } catch (e: Exception) {
                null
            }
        }
    }

}
