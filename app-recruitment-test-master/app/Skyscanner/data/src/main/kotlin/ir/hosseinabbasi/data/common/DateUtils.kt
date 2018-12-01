package ir.hosseinabbasi.data.common

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Dr.jacky on 11/6/2018.
 */
class DateUtils {

    companion object {

        private val calendar = Calendar.getInstance()
        private val yyyyMMdd = SimpleDateFormat("yyyy-MM-dd", Locale.US)
        private val date: Date
        private val nextDate: Date

        init {
            while (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
                calendar.add(Calendar.DATE, 1)
            }
            date = calendar.time
            calendar.add(Calendar.DATE, 1)
            nextDate = calendar.time
        }

        fun getOutboundDate(): String = yyyyMMdd.format(date)

        fun getInboundDate(): String = yyyyMMdd.format(nextDate)
    }
}