package com.example.android_school_spacex.response

import com.example.android_school_spacex.network.Transformable
import com.example.android_school_spacex.data.CompositeFairing
import kotlinx.serialization.Serializable

@Serializable
data class CompositeFairingObj(
    val heightObj: DimensionObj = DimensionObj(),
    val diameterObj: DimensionObj = DimensionObj()
) : Transformable<CompositeFairing> {

    override fun transform(): CompositeFairing {
        return CompositeFairing(
            height = heightObj.transform(),
            diameter = diameterObj.transform()
        )
    }
}