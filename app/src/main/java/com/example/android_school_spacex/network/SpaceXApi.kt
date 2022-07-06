package com.example.android_school_spacex.network

import com.example.android_school_spacex.network.response.SpaceXRocketObj
import retrofit2.http.GET

/**
 * API для обращения к SpaceX
 */
interface SpaceXApi {

    /**
     * Получить список ракет SpaceX
     */
    @GET(ServerUrls.Rockets.ROCKETS)
    suspend fun getAllRockets(): List<SpaceXRocketObj>
}