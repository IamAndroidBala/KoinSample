package com.androidbala.koinsample.data.api

import com.androidbala.koinsample.User
import retrofit2.Response
import retrofit2.http.GET

interface APIService {

    @GET("users")
    suspend fun getCars(): Response<List<User>>

}