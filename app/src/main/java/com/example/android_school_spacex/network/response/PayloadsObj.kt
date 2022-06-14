package com.example.android_school_spacex.network.response

import com.example.android_school_spacex.data.Payloads
import com.example.android_school_spacex.network.Transformable
import kotlinx.serialization.Serializable

@Serializable
data class PayloadsObj(
    val option1: String? = null,
    val option2: String? = null,
    val composite_fairing: CompositeFairingObj = CompositeFairingObj()
) : Transformable<Payloads> {

    override fun transform(): Payloads {
        return Payloads(
            option1 = option1 ?: "",
            option2 = option2 ?: "",
            compositeFairing = composite_fairing.transform()
        )
    }
}