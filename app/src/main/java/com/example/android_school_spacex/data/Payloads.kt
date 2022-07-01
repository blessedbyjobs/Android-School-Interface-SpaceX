package com.example.android_school_spacex.data

import java.io.Serializable

/**
 * Какой груз может нести ракета
 *
 * @param option1 первая опция
 * @param option2 вторая опция
 * @param compositeFairing данные обтекателя
 */
data class Payloads(
    val option1: String,
    val option2: String,
    val compositeFairing: CompositeFairing
) : Serializable