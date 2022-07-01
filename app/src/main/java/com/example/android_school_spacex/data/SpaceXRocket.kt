package com.example.android_school_spacex.data

import java.io.Serializable

/**
 * Данные о ракете
 *
 * @param id
 * @param active true, если программа запусков активна
 * @param stages число ступеней
 * @param boosters число ускорителей
 * @param costPerLaunch стоимость одного запуска
 * @param successRatePct процент удачных запусков
 * @param firstFlight дата первого полета
 * @param country страна запуска
 * @param company владелец
 * @param height высота
 * @param diameter диаметр
 * @param mass масса
 * @param payloadWeights данные полезной нагрузки
 * @param firstStage данные первой ступени
 * @param secondStage данные второй ступени
 * @param engines данные двигателей
 * @param landingLegs данные опор
 * @param wikipediaUrl ссылка на вики
 * @param description описание
 * @param rocketName название ракеты
 * @param rocketType тип ракеты
 */
data class SpaceXRocket(
    val id: String,
    val active: Boolean,
    val stages: Int,
    val boosters: Int,
    val costPerLaunch: Int,
    val successRatePct: Int,
    val firstFlight: String,
    val country: String,
    val company: String,
    val height: Dimension,
    val diameter: Dimension,
    val mass: Mass,
    val payloadWeights: List<PayloadWeights>,
    val firstStage: FirstStage,
    val secondStage: SecondStage,
    val engines: Engines,
    val landingLegs: LandingLegs,
    val wikipediaUrl: String,
    val description: String,
    val rocketName: String,
    val rocketType: String
) : Serializable