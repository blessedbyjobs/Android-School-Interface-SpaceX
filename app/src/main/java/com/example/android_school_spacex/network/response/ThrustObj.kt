package com.example.android_school_spacex.network.response

import com.example.android_school_spacex.data.Thrust
import com.example.android_school_spacex.network.Transformable
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