package com.malbyte.haditskalamunalim.ui.hadits.state

import com.malbyte.haditskalamunalim.data.source.remote.models.HaditsResponse

sealed class HaditsState {
    object Loading : HaditsState()
    data class Error(val message: String) : HaditsState()
    data class Success(val list: HaditsResponse) : HaditsState()
}