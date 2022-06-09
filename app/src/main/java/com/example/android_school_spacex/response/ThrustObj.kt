package com.example.android_school_spacex.response

import com.example.android_school_spacex.Transformable
import com.example.android_school_spacex.data.Thrust
import com.google.gson.annotations.SerializedName

data class ThrustObj(
    @SerializedName("kN") val kN: Int? = null,
    @SerializedName("lbf") val lbf: Int? = null
) : Transformable<Thrust> {

    override fun transform(): Thrust {
        return Thrust(
            kN = kN ?: 0,
            lbf = lbf ?: 0
        )
    }
}