package com.example.android_school_spacex.service

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.RecyclerView

/**
 * Модификация [RecyclerView], избавляющая от динамичного изменения размера списка
 * при разной высоте ячеек.
 *
 * Сохраняется максимальная высота на основе контента
 * и применяется ко всему списку
 */
class StretchRecyclerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RecyclerView(context, attrs, defStyleAttr) {

    private var maxMeasuredHeight: Int = 0

    override fun onMeasure(widthSpec: Int, heightSpec: Int) {
        val maxHeightSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED)
        super.onMeasure(widthSpec, maxHeightSpec)
        when {
            measuredHeight > maxMeasuredHeight -> maxMeasuredHeight = measuredHeight
            measuredHeight < maxMeasuredHeight -> setMeasuredDimension(
                measuredWidth,
                maxMeasuredHeight
            )
        }
    }
}