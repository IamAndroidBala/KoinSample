package com.androidbala.koinsample

import com.squareup.moshi.Json

data class User(

 @Json(name = "id")
 val id: Int = 0,

 @Json(name = "name")
 val name: String = "",

 @Json(name = "username")
 val username: String = "",

 @Json(name = "username")
 val email: String = "",

 @Json(name = "address")
 val address: AddressModel? = null,

 @Json(name = "geo")
 val geo: GeoModel? = null,

 @Json(name = "phone")
 val phone: String = "",

 @Json(name = "website")
 val website: String = "",

 @Json(name = "company")
 val company: CompanyModel? = null,

 )


data class AddressModel(

    @Json(name = "street")
    val street: String = "",

    @Json(name = "suite")
    val suite: String = "",

    @Json(name = "city")
    val city: String = "",

    @Json(name = "zipcode")
    val zipcode: String = "",

    )

data class GeoModel(

    @Json(name = "lat")
    val lat: String = "",

    @Json(name = "lng")
    val lng: String = ""

)

data class CompanyModel(

    @Json(name = "name")
    val name: String = "",

    @Json(name = "catchPhrase")
    val catchPhrase: String = "",

    @Json(name = "bs")
    val bs: String = ""

)