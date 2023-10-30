package com.malbyte.haditskalamunalim.ui.Perawi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.malbyte.haditskalamunalim.data.repository.MainRepository
import com.malbyte.haditskalamunalim.ui.Perawi.state.PerawiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PerawiViewModel(
    private val repository: MainRepository
) : ViewModel() {
    private var _getPerawi = MutableStateFlow<PerawiState?>(null)
    var getPerawi = _getPerawi.asStateFlow()

    fun getList() {
        viewModelScope.launch {
            _getPerawi.emit(PerawiState.Loading)
            try {
                _getPerawi.emit(PerawiState.Success(repository.getPerawi()))
            } catch (e: Exception) {
                _getPerawi.emit(PerawiState.Error(e.message.toString()))
            }
        }
    }
}