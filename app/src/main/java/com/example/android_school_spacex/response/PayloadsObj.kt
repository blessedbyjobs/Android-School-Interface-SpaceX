package com.example.android_school_spacex.response

import com.example.android_school_spacex.Transformable
import com.example.android_school_spacex.data.Payloads
import com.google.gson.annotations.SerializedName

data class PayloadsObj(
    @SerializedName("option_1") val option1: String? = null,
    @SerializedName("option_2") val option2: String? = null,
    @SerializedName("composite_fairing") val compositeFairingObj: CompositeFairingObj = CompositeFairingObj()
) : Transformable<Payloads> {

    override fun transform(): Payloads {
        return Payloads(
            option1 = option1 ?: "",
            option2 = option2 ?: "",
            compositeFairing = compositeFairingObj.transform()
        )
    }
}