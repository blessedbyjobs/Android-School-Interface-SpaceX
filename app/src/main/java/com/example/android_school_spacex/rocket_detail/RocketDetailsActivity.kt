package com.example.android_school_spacex.rocket_detail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_school_spacex.databinding.ActivityRocketDetailsBinding
import com.example.android_school_spacex.rocket_detail.controller.RocketCarouselController
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import ru.surfstudio.android.easyadapter.EasyAdapter
import ru.surfstudio.android.easyadapter.ItemList
import kotlin.coroutines.CoroutineContext

/**
 * Детальный экран с данными ракеты
 */
@ExperimentalCoroutinesApi
class RocketDetailsActivity : ComponentActivity(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    private val binding by lazy { ActivityRocketDetailsBinding.inflate(layoutInflater) }

    private val viewModel: RocketDetailsViewModel by viewModels {
        MyViewModelFactory(this, intent.extras)
    }

    private val detailsCarouselController = RocketCarouselController()

    private val easyAdapter = EasyAdapter()

    private var job = Job()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initViews()
        subscribeUi()
    }

    private fun initViews() {
        binding.rocketDetailsToolbar.setNavigationOnClickListener {
            finish()
        }
        with(binding.detailsRv) {
            layoutManager = LinearLayoutManager(context)
            adapter = easyAdapter
        }
    }

    private fun subscribeUi() {
        launch {
            viewModel.details.collect { details ->
                val items = ItemList.create().add(details, detailsCarouselController)
                easyAdapter.setItems(items)
            }
        }
        launch {
            viewModel.screenTitle.collect { binding.rocketDetailsToolbar.title = it }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }
}