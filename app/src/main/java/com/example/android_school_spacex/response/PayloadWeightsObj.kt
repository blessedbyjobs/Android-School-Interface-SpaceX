package com.example.android_school_spacex.response

import com.example.android_school_spacex.Transformable
import com.example.android_school_spacex.data.PayloadWeights
import com.google.gson.annotations.SerializedName

data class PayloadWeightsObj(
    @SerializedName("id") val id: String? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("kg") val kg: Int? = null,
    @SerializedName("lb") val lb: Int? = null
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