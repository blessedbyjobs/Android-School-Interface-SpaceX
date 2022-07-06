package com.example.android_school_spacex.rocket_detail.controller

import android.view.ViewGroup
import com.example.android_school_spacex.R
import com.example.android_school_spacex.data.RocketDetailBannerData
import com.example.android_school_spacex.databinding.ItemControllerRocketBannerBinding
import ru.surfstudio.android.easyadapter.controller.BindableItemController
import ru.surfstudio.android.easyadapter.holder.BindableViewHolder

/**
 * Контроллер с баннером
 */
class RocketBannerController :
    BindableItemController<RocketDetailBannerData, RocketBannerController.Holder>() {

    override fun getItemId(data: RocketDetailBannerData) = data.hashCode()

    override fun createViewHolder(parent: ViewGroup): Holder = Holder(parent)

    inner class Holder(parent: ViewGroup) :
        BindableViewHolder<RocketDetailBannerData>(parent, R.layout.item_controller_rocket_banner) {

        private val binding = ItemControllerRocketBannerBinding.bind(itemView)

        override fun bind(data: RocketDetailBannerData) {
            binding.rocketBannerTitleTv.text = data.title
            binding.rocketBannerSubtitleTv.text = data.subtitle
            binding.rocketBannerIv.setImageResource(data.imageRes)
        }
    }
}