package com.malbyte.haditskalamunalim.data.factory

import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

fun <VM : ViewModel> ViewModelFactory(intializer: (SavedStateHandle) -> VM): AbstractSavedStateViewModelFactory {
    return object : AbstractSavedStateViewModelFactory() {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(
            key: String,
            modelClass: Class<T>,
            handle: SavedStateHandle
        ): T {
            return intializer(handle) as T
        }

    }
}