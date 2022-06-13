package com.example.android_school_spacex.response

import com.example.android_school_spacex.network.Transformable
import com.example.android_school_spacex.data.Payloads
import kotlinx.serialization.Serializable

@Serializable
data class PayloadsObj(
    val option1: String? = null,
    val option2: String? = null,
    val compositeFairingObj: CompositeFairingObj = CompositeFairingObj()
) : Transformable<Payloads> {

    override fun transform(): Payloads {
        return Payloads(
            option1 = option1 ?: "",
            option2 = option2 ?: "",
            compositeFairing = compositeFairingObj.transform()
        )
    }
}