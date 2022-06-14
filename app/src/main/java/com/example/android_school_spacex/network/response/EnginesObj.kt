package com.example.android_school_spacex.network.response

import com.example.android_school_spacex.data.Engines
import com.example.android_school_spacex.network.Transformable
import kotlinx.serialization.Serializable

@Serializable
data class EnginesObj(
    val number: Int? = null,
    val type: String? = null,
    val version: String? = null,
    val layout: String? = null,
    val engine_loss_max: Int? = null,
    val propellant1: String? = null,
    val propellant2: String? = null,
    val thrust_sea_level: ThrustObj = ThrustObj(),
    val thrust_vacuum: ThrustObj = ThrustObj(),
    val thrust_to_weight: Double? = null
) : Transformable<Engines> {

    override fun transform(): Engines {
        return Engines(
            number = number ?: 0,
            type = type ?: "",
            version = version ?: "",
            layout = layout ?: "",
            engineLossMax = engine_loss_max ?: 0,
            propellant1 = propellant1 ?: "",
            propellant2 = propellant2 ?: "",
            thrustSeaLevel = thrust_sea_level.transform(),
            thrustVacuum = thrust_vacuum.transform(),
            thrustToWeight = thrust_to_weight ?: 0.0
        )
    }
}