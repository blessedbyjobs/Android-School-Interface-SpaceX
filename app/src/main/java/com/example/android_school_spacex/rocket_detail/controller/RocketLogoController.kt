package com.example.android_school_spacex.rocket_detail.controller

import android.view.ViewGroup
import com.example.android_school_spacex.R
import ru.surfstudio.android.easyadapter.controller.NoDataItemController
import ru.surfstudio.android.easyadapter.holder.BaseViewHolder

/**
 * Контроллер с логотипом ракеты
 */
class RocketLogoController : NoDataItemController<RocketLogoController.Holder>() {

    override fun createViewHolder(parent: ViewGroup): Holder = Holder(parent)

    inner class Holder(parent: ViewGroup) :
        BaseViewHolder(parent, R.layout.item_controller_rocket_logo)
}