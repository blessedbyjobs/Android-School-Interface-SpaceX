package com.example.android_school_spacex.network

import com.example.android_school_spacex.network.response.SpaceXRocketObj
import retrofit2.http.GET

interface SpaceXApi {

    @GET(ServerUrls.Rockets.ROCKETS)
    suspend fun getAllRockets(): List<SpaceXRocketObj>
}