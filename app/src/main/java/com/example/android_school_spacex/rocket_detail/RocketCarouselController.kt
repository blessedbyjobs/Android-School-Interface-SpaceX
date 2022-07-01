package com.example.android_school_spacex.rocket_detail

import android.view.ViewGroup
import com.example.android_school_spacex.R
import com.example.android_school_spacex.data.SeparateRocketDetail
import com.example.android_school_spacex.databinding.ItemRocketCarouselBinding
import ru.surfstudio.android.easyadapter.controller.BindableItemController
import ru.surfstudio.android.easyadapter.holder.BindableViewHolder

class RocketCarouselController :
    BindableItemController<List<SeparateRocketDetail>, RocketCarouselController.Holder>() {

    override fun getItemId(data: List<SeparateRocketDetail>) = data.hashCode()

    override fun createViewHolder(parent: ViewGroup): Holder = Holder(parent)

    inner class Holder(parent: ViewGroup) :
        BindableViewHolder<List<SeparateRocketDetail>>(parent, R.layout.item_rocket_carousel) {

        private val binding = ItemRocketCarouselBinding.bind(itemView)

        override fun bind(data: List<SeparateRocketDetail>) {
            binding.rocketDetailsCarousel.setup(data)
        }
    }
}