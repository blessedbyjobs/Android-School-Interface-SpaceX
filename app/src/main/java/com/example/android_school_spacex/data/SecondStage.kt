package com.example.android_school_spacex.data

import java.io.Serializable

/**
 * Данные второй ступени
 *
 * @param engines число двигателей
 * @param fuelAmountTons объем топлива в тоннах
 * @param burnTimeSec время горения
 * @param thrust данные тяги
 * @param payloads данные нагрузки
 */
data class SecondStage(
    val engines: Int,
    val fuelAmountTons: Double,
    val burnTimeSec: Int,
    val thrust: Thrust,
    val payloads: Payloads
) : Serializable