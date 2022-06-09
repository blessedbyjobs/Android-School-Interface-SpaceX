package com.example.android_school_spacex.response

import com.example.android_school_spacex.Transformable
import com.example.android_school_spacex.data.CompositeFairing
import com.google.gson.annotations.SerializedName

data class CompositeFairingObj(
    @SerializedName("height") val heightObj: DimensionObj = DimensionObj(),
    @SerializedName("diameter") val diameterObj: DimensionObj = DimensionObj()
) : Transformable<CompositeFairing> {

    override fun transform(): CompositeFairing {
        return CompositeFairing(
            height = heightObj.transform(),
            diameter = diameterObj.transform()
        )
    }
}