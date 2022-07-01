package com.example.android_school_spacex.data

import java.io.Serializable

/**
 * Данные посадочных опор
 *
 * @param number номер
 * @param material материал
 */
data class LandingLegs(
    val number: Int,
    val material: String
) : Serializable