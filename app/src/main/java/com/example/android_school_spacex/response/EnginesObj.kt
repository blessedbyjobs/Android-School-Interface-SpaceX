package com.example.android_school_spacex.response

import com.example.android_school_spacex.Transformable
import com.example.android_school_spacex.data.Engines
import com.google.gson.annotations.SerializedName

data class EnginesObj(
    @SerializedName("number") val number: Int? = null,
    @SerializedName("type") val type: String? = null,
    @SerializedName("version") val version: String? = null,
    @SerializedName("layout") val layout: String? = null,
    @SerializedName("engine_loss_max") val engineLossMax: Int? = null,
    @SerializedName("propellant_1") val propellant1: String? = null,
    @SerializedName("propellant_2") val propellant2: String? = null,
    @SerializedName("thrust_sea_level") val thrustSeaLevelObj: ThrustObj = ThrustObj(),
    @SerializedName("thrust_vacuum") val thrustVacuumObj: ThrustObj = ThrustObj(),
    @SerializedName("thrust_to_weight") val thrustToWeight: Int? = null
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