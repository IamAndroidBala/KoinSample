package com.androidbala.koinsample

import android.app.Application
import com.androidbala.koinsample.di.modules.appModule
import com.androidbala.koinsample.di.modules.repositoryModule
import com.androidbala.koinsample.di.modules.viewModelModule
import org.koin.core.context.startKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level

class MyKoinApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyKoinApplication)
            modules(listOf(appModule, repositoryModule, viewModelModule))
        }

    }
}