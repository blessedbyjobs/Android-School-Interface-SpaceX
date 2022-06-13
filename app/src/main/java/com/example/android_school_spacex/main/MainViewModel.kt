package com.example.android_school_spacex.main

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.android_school_spacex.data.SpaceXRocket
import com.example.android_school_spacex.network.SpaceXInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val spaceXInteractor: SpaceXInteractor,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val mainFlow = MutableStateFlow<MainState>(
        savedStateHandle.get(ROCKETS_SAVED_STATE_KEY) ?: MainState.Loading
    )

    @ExperimentalCoroutinesApi
    val rockets = mainFlow.flatMapLatest { getAllRockets() }.asLiveData()

    init {
        viewModelScope.launch {
            mainFlow.emitAll(getAllRockets())
        }
    }

    private fun getAllRockets(): Flow<MainState> {
        return flow<MainState> {
            emit(MainState.Success(spaceXInteractor.getAllRockets()))
        }.catch { error ->
            emit(MainState.Error(error))
        }.onStart {
            emit(MainState.Loading)
        }
    }

    companion object {
        private const val ROCKETS_SAVED_STATE_KEY = "ROCKETS_SAVED_STATE_KEY"
    }

    sealed class MainState {
        object Loading : MainState()
        data class Error(val error: Throwable) : MainState()
        data class Success(val rockets: List<SpaceXRocket>) : MainState()
    }
}