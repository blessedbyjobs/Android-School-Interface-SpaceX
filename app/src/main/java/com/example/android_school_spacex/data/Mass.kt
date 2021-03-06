package com.example.android_school_spacex.data

import java.io.Serializable

/**
 * Данные массы
 *
 * @param kg в киллограммах
 * @param lb в фунтах
 */
data class Mass(
    val kg: Int,
    val lb: Int
) : Serializable