package com.example.android_school_spacex.response

import com.example.android_school_spacex.Transformable
import com.example.android_school_spacex.data.Dimension
import com.google.gson.annotations.SerializedName

data class DimensionObj(
    @SerializedName("meters") val meters: Double? = null,
    @SerializedName("feet") val feet: Double? = null
) : Transformable<Dimension> {

    override fun transform(): Dimension {
        return Dimension(
            meters = meters ?: 0.0,
            feet = feet ?: 0.0
        )
    }
}