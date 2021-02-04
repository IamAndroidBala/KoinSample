package com.androidbala.koinsample.data.model

import com.squareup.moshi.Json

data class Albums(

    @Json(name = "userId")
    val userId: String,

    @Json(name = "id")
    val id: String,

    @Json(name = "title")
    val title: String

    )
