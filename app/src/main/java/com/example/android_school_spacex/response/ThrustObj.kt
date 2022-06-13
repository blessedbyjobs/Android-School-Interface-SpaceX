package com.example.android_school_spacex.response

import com.example.android_school_spacex.network.Transformable
import com.example.android_school_spacex.data.Thrust
import kotlinx.serialization.Serializable

@Serializable
data class ThrustObj(
    val kN: Int? = null,
    val lbf: Int? = null
) : Transformable<Thrust> {

    override fun transform(): Thrust {
        return Thrust(
            kN = kN ?: 0,
            lbf = lbf ?: 0
        )
    }
}