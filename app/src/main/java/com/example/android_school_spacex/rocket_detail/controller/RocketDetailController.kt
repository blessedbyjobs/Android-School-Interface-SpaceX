package com.example.android_school_spacex.rocket_detail.controller

import android.view.ViewGroup
import com.example.android_school_spacex.R
import com.example.android_school_spacex.data.SeparateRocketDetail
import com.example.android_school_spacex.databinding.ItemControllerRocketDetailBinding
import ru.surfstudio.android.easyadapter.controller.BindableItemController
import ru.surfstudio.android.easyadapter.holder.BindableViewHolder

/**
 * Контроллер для конкретной детали
 */
class RocketDetailController :
    BindableItemController<SeparateRocketDetail, RocketDetailController.Holder>() {

    override fun getItemId(data: SeparateRocketDetail) = data.subtitle.hashCode()

    override fun createViewHolder(parent: ViewGroup): Holder = Holder(parent)

    inner class Holder(parent: ViewGroup) :
        BindableViewHolder<SeparateRocketDetail>(parent, R.layout.item_controller_rocket_detail) {

        private val binding = ItemControllerRocketDetailBinding.bind(itemView)

        override fun bind(data: SeparateRocketDetail) {
            binding.rocketDetailView.title = data.title
            binding.rocketDetailView.subTitle = data.subtitle
        }
    }
}