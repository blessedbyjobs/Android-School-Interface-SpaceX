package com.example.android_school_spacex.rocket_detail.controller

import android.view.ViewGroup
import com.example.android_school_spacex.R
import com.example.android_school_spacex.data.SeparateRocketDetail
import com.example.android_school_spacex.databinding.ItemControllerRocketCarouselBinding
import ru.surfstudio.android.easyadapter.controller.BindableItemController
import ru.surfstudio.android.easyadapter.holder.BindableViewHolder

/**
 * Контроллер с каруселью деталей
 */
class RocketCarouselController :
    BindableItemController<List<SeparateRocketDetail>, RocketCarouselController.Holder>() {

    override fun getItemId(data: List<SeparateRocketDetail>) = "ROCKET_CAROUSEL_CONTROLLER"

    override fun createViewHolder(parent: ViewGroup): Holder = Holder(parent)

    inner class Holder(parent: ViewGroup) :
        BindableViewHolder<List<SeparateRocketDetail>>(
            parent,
            R.layout.item_controller_rocket_carousel
        ) {

        private val binding = ItemControllerRocketCarouselBinding.bind(itemView)

        override fun bind(data: List<SeparateRocketDetail>) {
            binding.rocketDetailsCarousel.setup(data)
        }
    }
}