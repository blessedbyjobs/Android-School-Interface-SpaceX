package com.example.android_school_spacex.data

import java.io.Serializable

/**
 * Данные нагрузки
 *
 * @param id для какой орбиты расчитана данная нагрузка
 * @param name название
 * @param mass данные массы
 */
data class PayloadWeights(
    val id: String,
    val name: String,
    val mass: Mass
) : Serializable