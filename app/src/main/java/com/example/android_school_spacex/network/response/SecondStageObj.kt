package com.example.android_school_spacex.network.response

import com.example.android_school_spacex.data.SecondStage
import com.example.android_school_spacex.network.Transformable
import kotlinx.serialization.Serializable

@Serializable
data class SecondStageObj(
    val engines: Int? = null,
    val fuelAmountTons: Double? = null,
    val burnTimeSec: Int? = null,
    val thrustObj: ThrustObj = ThrustObj(),
    val payloadsObj: PayloadsObj = PayloadsObj()
) : Transformable<SecondStage> {

    override fun transform(): SecondStage {
        return SecondStage(
            engines = engines ?: 1,
            fuelAmountTons = fuelAmountTons ?: 0.0,
            burnTimeSec = burnTimeSec ?: 0,
            thrust = thrustObj.transform(),
            payloads = payloadsObj.transform()
        )
    }
}