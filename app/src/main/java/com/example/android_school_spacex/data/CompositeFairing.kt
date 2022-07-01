package com.example.android_school_spacex.data

import java.io.Serializable

/**
 * Головной обтекатель
 *
 * @param height высота
 * @param diameter диаметр
 */
data class CompositeFairing(
    val height: Dimension,
    val diameter: Dimension
) : Serializable