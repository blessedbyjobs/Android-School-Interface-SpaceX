package com.example.android_school_spacex.rocket_detail.data

import com.example.android_school_spacex.data.SeparateRocketDetail
import com.example.android_school_spacex.rocket_detail.data.RocketDetailsUiItem.UiLogoItem
import com.example.android_school_spacex.rocket_detail.data.RocketDetailsUiItem.UiRocketDetailsItem

/**
 * Сущность которой делегировано создание элементов для рендера на экране
 */
object RocketDetailsItemsCreator {

    /**
     * @return список готовых для рендера элементов
     */
    fun createUiItems(details: List<SeparateRocketDetail>): MutableList<RocketDetailsUiItem> {
        val items = mutableListOf<RocketDetailsUiItem>()

        items.add(UiLogoItem)
        items.add(UiRocketDetailsItem(details))

        return items
    }
}