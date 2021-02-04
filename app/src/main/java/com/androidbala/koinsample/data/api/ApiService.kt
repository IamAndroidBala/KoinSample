package com.androidbala.koinsample.data.api

import com.androidbala.koinsample.User
import com.androidbala.koinsample.data.model.Albums
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getCars(): Response<List<User>>

    @GET("albums")
    suspend fun getAlbums(): Response<List<Albums>>

}