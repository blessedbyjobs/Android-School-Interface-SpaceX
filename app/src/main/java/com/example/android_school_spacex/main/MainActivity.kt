package com.example.android_school_spacex.main

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import com.example.android_school_spacex.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        subscribeUi()
    }

    private fun subscribeUi() {
        viewModel.rockets.observe(this) { state ->
            when (state) {
                is MainViewModel.MainState.Success -> {
                    Log.i("SpaceXApp", "data is successfully downloaded!")
                }
                is MainViewModel.MainState.Loading -> {
                    Log.i("SpaceXApp", "data is loading right now")
                }
                is MainViewModel.MainState.Error -> {
                    Log.i(
                        "SpaceXApp",
                        "data received with an error: ${state.error.localizedMessage}"
                    )
                }
            }
        }
    }
}