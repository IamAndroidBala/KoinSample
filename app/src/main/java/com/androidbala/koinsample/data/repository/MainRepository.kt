package com.androidbala.koinsample.data.repository

import com.androidbala.koinsample.data.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getUsers()  = apiHelper.getUsers()

    suspend fun getAlbums() = apiHelper.getAlbums()

}