package com.malbyte.haditskalamunalim.ui.Perawi.state

import com.malbyte.haditskalamunalim.data.source.remote.models.PerawiResponse

sealed class PerawiState {
    object Loading : PerawiState()
    data class Error(val message: String) : PerawiState()
    data class Success(val list: PerawiResponse) : PerawiState()
}