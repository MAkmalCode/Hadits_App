package com.malbyte.haditskalamunalim.ui.screen.hadits

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.malbyte.haditskalamunalim.data.repository.HaditsRepository
import com.malbyte.haditskalamunalim.ui.screen.hadits.state.HaditsState
import com.malbyte.haditskalamunalim.ui.screen.navArgs
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class HaditsViewModel(
    private val repository: HaditsRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _getHaditsState = MutableStateFlow<HaditsState?>(HaditsState.Loading)
    val getHaditsState = _getHaditsState.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        HaditsState.Loading
    )

    val perawi = savedStateHandle.navArgs<HaditsListScreenNavArgs>().perawi
    fun getHadits() {
        viewModelScope.launch {
            _getHaditsState.emit(HaditsState.Loading)
            try {
                _getHaditsState.emit(HaditsState.Success(repository.getHadits(perawi)))
            } catch (e: Exception) {
                _getHaditsState.emit(HaditsState.Error(e.message.toString()))
            }
        }
    }
}