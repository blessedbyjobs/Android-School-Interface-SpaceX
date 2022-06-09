package com.example.android_school_spacex.response

import com.example.android_school_spacex.Transformable
import com.example.android_school_spacex.data.FirstStage
import com.google.gson.annotations.SerializedName

data class FirstStageObj(
    @SerializedName("reusable") val reusable: Boolean? = null,
    @SerializedName("engines") val engines: Int? = null,
    @SerializedName("fuel_amount_tons") val fuelAmountTons: Double? = null,
    @SerializedName("burn_time_sec") val burnTimeSec: Int? = null,
    @SerializedName("thrust_sea_level") val thrustSeaLevelObj: ThrustObj = ThrustObj(),
    @SerializedName("thrust_vacuum") val thrustVacuumObj: ThrustObj = ThrustObj()
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