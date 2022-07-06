package com.example.android_school_spacex.data

import java.io.Serializable

/**
 * Данные двигателей
 *
 * @param number номер
 * @param type тип
 * @param version версия
 * @param layout компоновка
 * @param engineLossMax
 * @param propellant1 первый тип топлива
 * @param propellant2 второй тип топлива
 * @param thrustSeaLevel тяга на уровне моря
 * @param thrustVacuum тяга в вакууме
 * @param thrustToWeight отношение тяги к массе
 */
data class Engines(
    val number: Int,
    val type: String,
    val version: String,
    val layout: String,
    val engineLossMax: Int,
    val propellant1: String,
    val propellant2: String,
    val thrustSeaLevel: Thrust,
    val thrustVacuum: Thrust,
    val thrustToWeight: Double
) : Serializable