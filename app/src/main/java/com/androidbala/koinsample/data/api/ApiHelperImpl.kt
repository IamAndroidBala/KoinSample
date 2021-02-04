package com.androidbala.koinsample.data.api

import com.androidbala.koinsample.User
import com.androidbala.koinsample.data.model.Albums
import retrofit2.Response

class ApiHelperImpl(private val apiService: ApiService) : ApiHelper {

    override suspend fun getUsers(): Response<List<User>> = apiService.getCars()

    override suspend fun getAlbums(): Response<List<Albums>> = apiService.getAlbums()

}