package com.example.android_school_spacex.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_school_spacex.data.SpaceXRocket
import com.example.android_school_spacex.network.LoadState
import com.example.android_school_spacex.network.Request
import com.example.android_school_spacex.network.RequestUtils.requestFlow
import com.example.android_school_spacex.network.SpaceXInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel главного экран приложения
 */
@HiltViewModel
@ExperimentalCoroutinesApi
class MainViewModel @Inject constructor(
    private val spaceXInteractor: SpaceXInteractor
) : ViewModel() {

    private val _loadState = MutableStateFlow(LoadState.LOADING)

    private val _rockets = MutableStateFlow(emptyList<SpaceXRocket>())

    /** Список ракет **/
    val rockets: StateFlow<List<SpaceXRocket>> get() = _rockets.asStateFlow()

    init {
        loadRockets()
    }

    private fun loadRockets() {
        viewModelScope.launch {
            requestFlow {
                spaceXInteractor.getAllRockets()
            }.collect { requestState ->
                when (requestState) {
                    is Request.Loading -> {
                        // TODO показать состояние загрузки
                        _loadState.value = LoadState.LOADING
                    }
                    is Request.Success -> {
                        _rockets.value = requestState.data
                        _loadState.value = LoadState.SUCCESS
                    }
                    is Request.Error -> {
                        // TODO показать состояние ошибки
                        _loadState.value = LoadState.ERROR
                    }
                }
            }
        }
    }
}