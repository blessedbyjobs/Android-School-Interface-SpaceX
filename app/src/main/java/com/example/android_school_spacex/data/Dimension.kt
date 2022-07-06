package com.example.android_school_spacex.data

import java.io.Serializable

/**
 * Данные величины (диаметр, высота и т.д.)
 *
 * @param meters в метрах
 * @param feet в футах
 */
data class Dimension(
    val meters: Double,
    val feet: Double
) : Serializable