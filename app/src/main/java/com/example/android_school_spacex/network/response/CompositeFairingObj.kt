package com.example.android_school_spacex.network.response

import com.example.android_school_spacex.data.CompositeFairing
import com.example.android_school_spacex.network.Transformable
import kotlinx.serialization.Serializable

@Serializable
data class CompositeFairingObj(
    val height: DimensionObj = DimensionObj(),
    val diameter: DimensionObj = DimensionObj()
) : Transformable<CompositeFairing> {

    override fun transform(): CompositeFairing {
        return CompositeFairing(
            height = height.transform(),
            diameter = diameter.transform()
        )
    }
}