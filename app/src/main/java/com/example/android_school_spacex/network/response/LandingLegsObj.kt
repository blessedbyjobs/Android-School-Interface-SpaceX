package com.example.android_school_spacex.network.response

import com.example.android_school_spacex.data.LandingLegs
import com.example.android_school_spacex.network.Transformable
import kotlinx.serialization.Serializable

@Serializable
data class LandingLegsObj(
    val number: Int? = null,
    val material: String? = null
) : Transformable<LandingLegs> {

    override fun transform(): LandingLegs {
        return LandingLegs(
            number = number ?: -1,
            material = material ?: ""
        )
    }
}