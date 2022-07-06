package com.example.android_school_spacex.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_school_spacex.databinding.ActivityMainBinding
import com.example.android_school_spacex.main.controller.RocketsAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import kotlin.coroutines.CoroutineContext

/**
 * Главный экран приложения: список ракет
 */
@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainActivity : ComponentActivity(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    private val viewModel: MainViewModel by viewModels()
    private val rocketsAdapter = RocketsAdapter()

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private var job = Job()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initViews()

        launch { subscribeUi() }
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }

    private fun initViews() {
        with(binding.rocketsRv) {
            layoutManager = LinearLayoutManager(context)
            adapter = rocketsAdapter
        }
    }

    private suspend fun subscribeUi() {
        viewModel.rockets.collect { rockets ->
            rocketsAdapter.update(rockets)
        }
    }
}