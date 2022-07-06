package com.example.android_school_spacex.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.cardview.widget.CardView
import androidx.core.content.withStyledAttributes
import com.example.android_school_spacex.R
import com.example.android_school_spacex.databinding.RocketDetailInfoViewBinding
import com.example.android_school_spacex.service.dip

class RocketDetailView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : CardView(context, attrs) {

    private val binding =
        RocketDetailInfoViewBinding.inflate(LayoutInflater.from(context), this)

    var title: String = ""
        set(value) {
            field = value
            binding.titleTv.text = value
        }

    var subTitle: String = ""
        set(value) {
            field = value
            binding.subtitleTv.text = value
        }

    init {
        radius = dip(18).toFloat()
        elevation = dip(24).toFloat()
        context.withStyledAttributes(attrs, R.styleable.RocketDetailView) {
            title = getString(R.styleable.RocketDetailView_rdv_title) ?: ""
            subTitle = getString(R.styleable.RocketDetailView_rdv_subTitle) ?: ""
        }
    }
}
