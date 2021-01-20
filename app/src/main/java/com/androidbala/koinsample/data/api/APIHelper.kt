package com.androidbala.koinsample.data.api

import com.androidbala.koinsample.User
import retrofit2.Response

interface APIHelper {
    suspend fun getUsers() : Response<List<User>>
}