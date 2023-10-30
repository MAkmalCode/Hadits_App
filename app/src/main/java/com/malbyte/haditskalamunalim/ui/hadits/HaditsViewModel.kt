package com.malbyte.haditskalamunalim.ui.hadits

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.malbyte.haditskalamunalim.data.repository.MainRepository
import com.malbyte.haditskalamunalim.ui.hadits.state.HaditsState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HaditsViewModel(
    private val repository: MainRepository
) : ViewModel() {
    private val _getHaditsState = MutableStateFlow<HaditsState?>(null)
    val getHaditsState = _getHaditsState.asStateFlow()

    fun getHadits(
        perawi: String,
        page: Int
    ) {
        viewModelScope.launch {
            _getHaditsState.emit(HaditsState.Loading)
            try {
                _getHaditsState.emit(HaditsState.Success(repository.getHadits(perawi, page)))
            } catch (e: Exception) {
                _getHaditsState.emit(HaditsState.Error(e.message.toString()))
            }
        }
    }
}