package com.example.android_school_spacex.response

import com.example.android_school_spacex.Transformable
import com.example.android_school_spacex.data.LandingLegs
import com.google.gson.annotations.SerializedName

data class LandingLegsObj(
    @SerializedName("number") val number: Int? = null,
    @SerializedName("material") val material: String? = null
) : Transformable<LandingLegs> {
    override fun transform(): LandingLegs {
        return LandingLegs(
            number = number ?: -1,
            material = material ?: ""
        )
    }
}