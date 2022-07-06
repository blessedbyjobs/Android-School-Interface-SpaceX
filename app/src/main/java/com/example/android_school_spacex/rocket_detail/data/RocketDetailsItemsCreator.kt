package com.example.android_school_spacex.rocket_detail.data

import com.example.android_school_spacex.R
import com.example.android_school_spacex.data.RocketDetailBannerData
import com.example.android_school_spacex.data.SeparateRocketDetail
import com.example.android_school_spacex.rocket_detail.data.RocketDetailsUiItem.*

/**
 * Сущность которой делегировано создание элементов для рендера на экране
 */
object RocketDetailsItemsCreator {

    /**
     * @return список готовых для рендера элементов
     */
    fun createUiItems(details: List<SeparateRocketDetail>): MutableList<RocketDetailsUiItem> {
        val items = mutableListOf<RocketDetailsUiItem>()

        items.addLogo()
        items.addDetails(details)
        items.addBanner()

        return items
    }

    /**
     * Добавить логотип
     */
    private fun MutableList<RocketDetailsUiItem>.addLogo() {
        add(UiLogoItem)
    }

    /**
     * Добавить детали
     */
    private fun MutableList<RocketDetailsUiItem>.addDetails(details: List<SeparateRocketDetail>) {
        add(UiRocketDetailsItem(details))
    }

    /**
     * Добавить баннер
     */
    private fun MutableList<RocketDetailsUiItem>.addBanner() {
        add(
            UiRocketDetailsBannerItem(
                data = RocketDetailBannerData(
                    title = "Занимаясь серфингом в космосе, не забывай надевать шлем!",
                    subtitle = "И пролетая мимо помаши нам ручкой",
                    imageRes = R.drawable.ic_astronaut_picture
                )
            )
        )
    }
}