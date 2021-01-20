package com.androidbala.koinsample.data.repository

import com.androidbala.koinsample.data.api.APIHelper

class MainRepository(private val apiHelper: APIHelper) {
    suspend fun getUsers() = apiHelper.getUsers()
}