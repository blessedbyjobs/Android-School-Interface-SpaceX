package com.example.android_school_spacex.rocket_detail.data

import com.example.android_school_spacex.data.RocketDetailBannerData
import com.example.android_school_spacex.data.SeparateRocketDetail

/**
 * Элемент на экране деталей ракеты
 */
sealed class RocketDetailsUiItem {

    /** Логотип **/
    object UiLogoItem : RocketDetailsUiItem()

    /** Детали отдельной ракеты **/
    data class UiRocketDetailsItem(val details: List<SeparateRocketDetail>) : RocketDetailsUiItem()

    /** Данные баннера **/
    data class UiRocketDetailsBannerItem(val data: RocketDetailBannerData) : RocketDetailsUiItem()
}