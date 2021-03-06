package com.example.android_school_spacex.network.response

import com.example.android_school_spacex.data.Mass
import com.example.android_school_spacex.network.Transformable
import kotlinx.serialization.Serializable

@Serializable
data class MassObj(
    val kg: Int? = null,
    val lb: Int? = null
) : Transformable<Mass> {

    override fun transform(): Mass {
        return Mass(
            kg = kg ?: 0,
            lb = lb ?: 0
        )
    }
}