package com.example.android_school_spacex.response

import com.example.android_school_spacex.Transformable
import com.example.android_school_spacex.data.Mass
import com.google.gson.annotations.SerializedName

data class MassObj(
    @SerializedName("kg") val kg: Int? = null,
    @SerializedName("lb") val lb: Int? = null
) : Transformable<Mass> {

    override fun transform(): Mass {
        return Mass(
            kg = kg ?: 0,
            lb = lb ?: 0
        )
    }
}