package com.example.android_school_spacex.response

import com.example.android_school_spacex.network.Transformable
import com.example.android_school_spacex.data.Engines
import kotlinx.serialization.Serializable

@Serializable
data class EnginesObj(
    val number: Int? = null,
    val type: String? = null,
    val version: String? = null,
    val layout: String? = null,
    val engineLossMax: Int? = null,
    val propellant1: String? = null,
    val propellant2: String? = null,
    val thrustSeaLevelObj: ThrustObj = ThrustObj(),
    val thrustVacuumObj: ThrustObj = ThrustObj(),
    val thrustToWeight: Int? = null
) : Transformable<Engines> {

    override fun transform(): Engines {
        return Engines(
            number = number ?: 0,
            type = type ?: "",
            version = version ?: "",
            layout = layout ?: "",
            engineLossMax = engineLossMax ?: 0,
            propellant1 = propellant1 ?: "",
            propellant2 = propellant2 ?: "",
            thrustSeaLevel = thrustSeaLevelObj.transform(),
            thrustVacuum = thrustVacuumObj.transform(),
            thrustToWeight = thrustToWeight ?: 0
        )
    }
}