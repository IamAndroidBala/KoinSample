package com.androidbala.koinsample.di.modules

import com.androidbala.koinsample.ui.album.AlbumViewModel
import com.androidbala.koinsample.ui.user.viewmodel.UserViewModel
import org.koin.dsl.module

val viewModelModule = module {
    single {
        UserViewModel(get(), get())
    }

    single {
        AlbumViewModel(get(), get())
    }
}