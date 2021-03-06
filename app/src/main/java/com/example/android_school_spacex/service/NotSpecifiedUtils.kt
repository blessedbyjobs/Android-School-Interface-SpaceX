package com.example.android_school_spacex.service

import androidx.annotation.DrawableRes
import com.example.android_school_spacex.R
import com.example.android_school_spacex.data.SeparateRocketDetail
import com.example.android_school_spacex.data.SpaceXRocket

/**
 * Объект с утилитарными методами, которые сложно классифицировать
 */
object NotSpecifiedUtils {

    /**
     * @return ресурс картинки в зависимости от [SpaceXRocket.id]
     */
    @DrawableRes
    fun SpaceXRocket.getImageAccordingToId(): Int {
        return when (id) {
            FALCON_1_ID -> R.drawable.ic_spacex_rocket_stub_1
            FALCON_9_ID -> R.drawable.ic_spacex_rocket_stub_2
            FALCON_HEAVY_ID -> R.drawable.ic_spacex_rocket_stub_3
            STARSHIP_ID -> R.drawable.ic_spacex_rocket_stub_4
            else -> R.drawable.ic_spacex_rocket
        }
    }

    /**
     * @return список с упрощенными деталями ракеты
     */
    fun SpaceXRocket.getSeparateDetails(): MutableList<SeparateRocketDetail> {
        val details = mutableListOf<SeparateRocketDetail>()
        with(details) {
            add(
                SeparateRocketDetail(
                    title = height.meters.toString(),
                    subtitle = "Высота, m"
                )
            )
            add(
                SeparateRocketDetail(
                    title = diameter.meters.toString(),
                    subtitle = "Диаметр, m"
                )
            )
            add(
                SeparateRocketDetail(
                    title = mass.kg.toString(),
                    subtitle = "Масса, kg"
                )
            )
            add(
                SeparateRocketDetail(
                    title = stages.toString(),
                    subtitle = "Ступеней"
                )
            )
            add(
                SeparateRocketDetail(
                    title = boosters.toString(),
                    subtitle = "Ускорителей"
                )
            )
            add(
                SeparateRocketDetail(
                    title = company,
                    subtitle = "Владелец"
                )
            )
        }
        return details
    }

    private const val FALCON_1_ID = "5e9d0d95eda69955f709d1eb"
    private const val FALCON_9_ID = "5e9d0d95eda69973a809d1ec"
    private const val FALCON_HEAVY_ID = "5e9d0d95eda69974db09d1ed"
    private const val STARSHIP_ID = "5e9d0d96eda699382d09d1ee"
}