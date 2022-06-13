package com.example.android_school_spacex.network

/** Интерфейс, указывающий что объект может быть трансформирован в объект типа T */
fun interface Transformable<T> {
    fun transform(): T
}