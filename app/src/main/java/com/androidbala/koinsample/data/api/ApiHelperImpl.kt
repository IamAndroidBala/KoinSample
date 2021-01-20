package com.androidbala.koinsample.data.api

import com.androidbala.koinsample.User
import retrofit2.Response

class ApiHelperImpl(private val apiService: APIService) : APIHelper {

    override suspend fun getUsers(): Response<List<User>> = apiService.getCars()

}