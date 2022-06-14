package com.example.android_school_spacex.service

import java.text.SimpleDateFormat
import java.util.*

object StringUtils {

    /**
     * Метод, преобразующий дату вида "гггг-мм-дд" в "д месяц гггг"
     */
    fun String.getFormattedDateWithYear(): String {
        return try {
            var sdfDate = SimpleDateFormat("yyyy-MM-dd", Locale("ru"))
            val stringDate = sdfDate.parse(this)
            sdfDate = SimpleDateFormat("d MMMM yyyy", Locale("ru"))

            return sdfDate.format(stringDate)
        } catch (e: Exception) {
            ""
        }
    }
}