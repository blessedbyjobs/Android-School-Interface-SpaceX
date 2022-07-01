package com.example.android_school_spacex.rocket_detail

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_school_spacex.data.SeparateRocketDetail
import com.example.android_school_spacex.databinding.RocketDetailsCarouselViewBinding.inflate
import ru.surfstudio.android.easyadapter.EasyAdapter
import ru.surfstudio.android.easyadapter.ItemList

class RocketDetailsCarouselView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : LinearLayout(context, attrs) {

    private val productsAdapter = EasyAdapter()

    private val binding = inflate(LayoutInflater.from(context), this)

    init {
        orientation = VERTICAL
        initRecycler()
    }

    /**
     * Инициализация вью
     */
    fun setup(details: List<SeparateRocketDetail>) {
        ItemList.create()
            .addAll(details, RocketDetailController())
            .let { productsAdapter.setItems(it) }
    }

    private fun initRecycler() {
        binding.detailsCarouselRv.adapter = productsAdapter
        binding.detailsCarouselRv.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }
}