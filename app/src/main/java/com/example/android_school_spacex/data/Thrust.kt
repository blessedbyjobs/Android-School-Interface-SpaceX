package com.example.android_school_spacex.data

import java.io.Serializable

/**
 * Данные тяги
 *
 * @param kN тяга в килоньютонах
 * @param lbf тяга в фунт-силах
 */
data class Thrust(
    val kN: Int,
    val lbf: Int
) : Serializable