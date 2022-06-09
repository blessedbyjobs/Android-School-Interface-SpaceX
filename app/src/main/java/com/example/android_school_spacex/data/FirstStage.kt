package com.example.android_school_spacex.data

/**
 * Данные первой ступени
 *
 * @param reusable true, если можно использовать повторно
 * @param engines число двигателей
 * @param fuelAmountTons объем топлива в тоннах
 * @param burnTimeSec время горения
 * @param thrustSeaLevel тяга на уровне моря
 * @param thrustVacuum тяга в вакууме
 */
data class FirstStage(
    val reusable: Boolean,
    val engines: Int,
    val fuelAmountTons: Double,
    val burnTimeSec: Int,
    val thrustSeaLevel: Thrust,
    val thrustVacuum: Thrust
)