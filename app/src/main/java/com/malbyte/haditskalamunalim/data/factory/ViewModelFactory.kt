package com.malbyte.haditskalamunalim.data.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.malbyte.haditskalamunalim.data.repository.MainRepository
import com.malbyte.haditskalamunalim.di.Injection
import com.malbyte.haditskalamunalim.ui.Perawi.PerawiViewModel
import com.malbyte.haditskalamunalim.ui.hadits.HaditsViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(
    private val repository: MainRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(PerawiViewModel::class.java) -> PerawiViewModel(repository) as T
            modelClass.isAssignableFrom(HaditsViewModel::class.java) -> HaditsViewModel(repository) as T
            else -> throw Throwable("Unknown ViewModel Class" + modelClass.name)
        }

    companion object {
        @Volatile
        private var INSTANCE: ViewModelFactory? = null

        fun getInstance(): ViewModelFactory = INSTANCE ?: synchronized(this){
            INSTANCE ?: ViewModelFactory(MainRepository(Injection.provideApi()))
                .also { INSTANCE = it }
        }
    }
}