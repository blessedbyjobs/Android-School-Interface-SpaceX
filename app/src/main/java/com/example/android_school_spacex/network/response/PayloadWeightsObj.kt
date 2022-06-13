package com.example.android_school_spacex.network.response

import com.example.android_school_spacex.data.PayloadWeights
import com.example.android_school_spacex.network.Transformable
import kotlinx.serialization.Serializable

@Serializable
data class PayloadWeightsObj(
    val id: String? = null,
    val name: String? = null,
    val kg: Int? = null,
    val lb: Int? = null
) : Transformable<PayloadWeights> {

    override fun transform(): PayloadWeights {
        return PayloadWeights(
            id = id ?: "",
            name = name ?: "",
            mass = MassObj(
                kg = kg ?: 0,
                lb = lb ?: 0
            ).transform()
        )
    }
}