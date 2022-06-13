package com.example.android_school_spacex.network.response

import com.example.android_school_spacex.data.Dimension
import com.example.android_school_spacex.network.Transformable
import kotlinx.serialization.Serializable

@Serializable
data class DimensionObj(
    val meters: Double? = null,
    val feet: Double? = null
) : Transformable<Dimension> {

    override fun transform(): Dimension {
        return Dimension(
            meters = meters ?: 0.0,
            feet = feet ?: 0.0
        )
    }
}