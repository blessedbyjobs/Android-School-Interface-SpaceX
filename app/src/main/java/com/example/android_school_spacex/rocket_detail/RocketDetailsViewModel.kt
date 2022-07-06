package com.example.android_school_spacex.rocket_detail

import android.os.Bundle
import androidx.lifecycle.*
import androidx.savedstate.SavedStateRegistryOwner
import com.example.android_school_spacex.data.SpaceXRocket
import com.example.android_school_spacex.rocket_detail.data.RocketDetailsItemsCreator
import com.example.android_school_spacex.rocket_detail.data.RocketDetailsUiItem
import com.example.android_school_spacex.service.NotSpecifiedUtils.getSeparateDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel детального экрана с данными ракеты
 */
@HiltViewModel
@ExperimentalCoroutinesApi
class RocketDetailsViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel(), LifecycleObserver {

    private val _screenTitle = MutableStateFlow("")

    /** Заголовок экрана **/
    val screenTitle: StateFlow<String> get() = _screenTitle.asStateFlow()

    private val _items = MutableStateFlow(emptyList<RocketDetailsUiItem>())

    /** Список элементов экрана **/
    val items: StateFlow<List<RocketDetailsUiItem>> get() = _items.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            savedStateHandle.get<SpaceXRocket>("ROCKET_DATA")?.let { rocket ->
                _screenTitle.value = rocket.rocketName
                _items.value = RocketDetailsItemsCreator.createUiItems(
                    rocket.getSeparateDetails()
                )
            }
        }
    }
}

@ExperimentalCoroutinesApi
class MyViewModelFactory(
    owner: SavedStateRegistryOwner,
    defaultArgs: Bundle? = null
) : AbstractSavedStateViewModelFactory(owner, defaultArgs) {
    override fun <T : ViewModel> create(
        key: String, modelClass: Class<T>, handle: SavedStateHandle
    ): T {
        return RocketDetailsViewModel(handle) as T
    }
}