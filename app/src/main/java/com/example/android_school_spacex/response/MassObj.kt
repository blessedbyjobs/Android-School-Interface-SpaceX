package com.example.android_school_spacex.response

import com.example.android_school_spacex.network.Transformable
import com.example.android_school_spacex.data.Mass
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