package com.malbyte.haditskalamunalim.ui.screen.hadits

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.malbyte.haditskalamunalim.data.repository.HaditsRepository
import com.malbyte.haditskalamunalim.ui.screen.navArgs

class HaditsViewModel(
    private val repository: HaditsRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    val perawiSlug = savedStateHandle.navArgs<HaditsListScreenNavArgs>().perawi
    var perawiName by mutableStateOf("")
        private set
    val getHadits = repository.getHadits(perawiSlug, perawiName = { perawiName = it })
}