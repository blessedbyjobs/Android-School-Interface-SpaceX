package com.example.android_school_spacex.response

import com.example.android_school_spacex.network.Transformable
import com.example.android_school_spacex.data.FirstStage
import kotlinx.serialization.Serializable

@Serializable
data class FirstStageObj(
    val reusable: Boolean? = null,
    val engines: Int? = null,
    val fuelAmountTons: Double? = null,
    val burnTimeSec: Int? = null,
    val thrustSeaLevelObj: ThrustObj = ThrustObj(),
    val thrustVacuumObj: ThrustObj = ThrustObj()
) : Transformable<FirstStage> {

    override fun transform(): FirstStage {
        return FirstStage(
            reusable = reusable ?: false,
            engines = engines ?: 1,
            fuelAmountTons = fuelAmountTons ?: 0.0,
            burnTimeSec = burnTimeSec ?: 0,
            thrustSeaLevel = thrustSeaLevelObj.transform(),
            thrustVacuum = thrustVacuumObj.transform()
        )
    }
}