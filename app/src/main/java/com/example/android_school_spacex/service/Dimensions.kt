@file:Suppress("NOTHING_TO_INLINE", "unused")

package com.example.android_school_spacex.service

import android.content.Context
import android.content.res.Resources
import android.view.View
import androidx.annotation.DimenRes

//convert pixels to dp
fun Int.toDp(): Int = (this / Resources.getSystem().displayMetrics.density).toInt()

//convert dp tp pixels
fun Int.toPx(): Int = (this * Resources.getSystem().displayMetrics.density).toInt()

//convert pixels to sp
fun Int.toSp(): Int = (this * Resources.getSystem().displayMetrics.scaledDensity).toInt()

// returns dip(dp) dimension value in pixels
fun Context.dip(value: Int): Int = (value * resources.displayMetrics.density).toInt()
fun Context.dip(value: Float): Int = (value * resources.displayMetrics.density).toInt()

// return sp dimension value in pixels
fun Context.sp(value: Int): Int = (value * resources.displayMetrics.scaledDensity).toInt()
fun Context.sp(value: Float): Int = (value * resources.displayMetrics.scaledDensity).toInt()

// converts px value into dip or sp
fun Context.px2dip(px: Int): Float = px.toFloat() / resources.displayMetrics.density
fun Context.px2sp(px: Int): Float = px.toFloat() / resources.displayMetrics.scaledDensity

fun Context.dimen(@DimenRes resource: Int): Int = resources.getDimensionPixelSize(resource)

// the same for the views
inline fun View.dip(value: Int): Int = context.dip(value)
inline fun View.dip(value: Float): Int = context.dip(value)
inline fun View.sp(value: Int): Int = context.sp(value)
inline fun View.sp(value: Float): Int = context.sp(value)
inline fun View.px2dip(px: Int): Float = context.px2dip(px)
inline fun View.px2sp(px: Int): Float = context.px2sp(px)
inline fun View.dimen(@DimenRes resource: Int): Int = context.dimen(resource)
