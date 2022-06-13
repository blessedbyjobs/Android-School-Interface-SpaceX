package com.example.android_school_spacex.network

import com.example.android_school_spacex.data.SpaceXRocket

class SpaceXInteractor(
    private val spaceXApi: SpaceXApi
) {

    suspend fun getAllRockets(): List<SpaceXRocket> {
        return spaceXApi.getAllRockets().map { it.transform() }
    }
}