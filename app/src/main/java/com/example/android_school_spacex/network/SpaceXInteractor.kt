package com.example.android_school_spacex.network

import com.example.android_school_spacex.data.SpaceXRocket

/**
 * Интерактор для работы с API
 *
 * Представляет собой реализацию паттерна "Фасад":
 * маскирует обращение к API и возвращает смапленные данные
 */
class SpaceXInteractor(
    private val spaceXApi: SpaceXApi
) {

    /** @see [SpaceXApi.getAllRockets] **/
    suspend fun getAllRockets(): List<SpaceXRocket> {
        return spaceXApi.getAllRockets().map { it.transform() }
    }
}