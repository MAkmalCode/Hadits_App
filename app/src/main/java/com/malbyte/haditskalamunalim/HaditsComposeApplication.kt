package com.malbyte.haditskalamunalim

import android.app.Application
import com.malbyte.haditskalamunalim.data.repository.HaditsRepository
import com.malbyte.haditskalamunalim.data.repository.HaditsrepositoryImpl
import com.malbyte.haditskalamunalim.di.AppModule
import com.malbyte.haditskalamunalim.di.AppModuleImpl

class HaditsComposeApplication : Application(){
    companion object{
        lateinit var repository: HaditsRepository
        private lateinit var appModule: AppModule
    }
    override fun onCreate() {
        super.onCreate()
        appModule = AppModuleImpl()
        repository = HaditsrepositoryImpl(appModule.haditsApi)
    }
}