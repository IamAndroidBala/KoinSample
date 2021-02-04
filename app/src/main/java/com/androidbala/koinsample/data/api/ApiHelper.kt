package com.androidbala.koinsample.data.api

import com.androidbala.koinsample.User
import com.androidbala.koinsample.data.model.Albums
import retrofit2.Response

interface ApiHelper {

    suspend fun getUsers() : Response<List<User>>

    suspend fun getAlbums() : Response<List<Albums>>

}