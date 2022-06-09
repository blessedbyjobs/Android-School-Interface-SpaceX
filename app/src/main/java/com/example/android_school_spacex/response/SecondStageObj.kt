package com.example.android_school_spacex.response

import com.example.android_school_spacex.Transformable
import com.example.android_school_spacex.data.SecondStage
import com.google.gson.annotations.SerializedName

data class SecondStageObj(
    @SerializedName("engines") val engines: Int? = null,
    @SerializedName("fuel_amount_tons") val fuelAmountTons: Double? = null,
    @SerializedName("burn_time_sec") val burnTimeSec: Int? = null,
    @SerializedName("thrust") val thrustObj: ThrustObj = ThrustObj(),
    @SerializedName("payloads") val payloadsObj: PayloadsObj = PayloadsObj()
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