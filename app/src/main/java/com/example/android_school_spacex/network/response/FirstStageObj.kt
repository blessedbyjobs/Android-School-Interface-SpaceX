package com.example.android_school_spacex.network.response

import com.example.android_school_spacex.data.FirstStage
import com.example.android_school_spacex.network.Transformable
import kotlinx.serialization.Serializable

@Serializable
data class FirstStageObj(
    val reusable: Boolean? = null,
    val engines: Int? = null,
    val fuel_amount_tons: Double? = null,
    val burn_time_sec: Int? = null,
    val thrust_sea_level: ThrustObj = ThrustObj(),
    val thrust_vacuum: ThrustObj = ThrustObj()
) : Transformable<FirstStage> {

    override fun transform(): FirstStage {
        return FirstStage(
            reusable = reusable ?: false,
            engines = engines ?: 1,
            fuelAmountTons = fuel_amount_tons ?: 0.0,
            burnTimeSec = burn_time_sec ?: 0,
            thrustSeaLevel = thrust_sea_level.transform(),
            thrustVacuum = thrust_vacuum.transform()
        )
    }
}