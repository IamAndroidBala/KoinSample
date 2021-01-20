package com.androidbala.koinsample.di.modules

import com.androidbala.koinsample.data.repository.MainRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { MainRepository(get()) }
}