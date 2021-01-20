package com.androidbala.koinsample.di.modules

import com.androidbala.koinsample.ui.user.UserViewModel
import org.koin.dsl.module

val viewModelModule = module {
    single {
        UserViewModel(get(), get())
    }
}