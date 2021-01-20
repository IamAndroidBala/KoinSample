package com.androidbala.koinsample.di.modules

import android.content.Context
import com.androidbala.koinsample.BuildConfig
import com.androidbala.koinsample.data.api.APIHelper
import com.androidbala.koinsample.data.api.APIService
import com.androidbala.koinsample.data.api.ApiHelperImpl
import com.androidbala.koinsample.utils.NetworkHelper
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val appModule = module {
    single { provideOkHttpClient() }
    single { provideRetrofit(get(), BuildConfig.BASE_URL) }
    single { provideApiService(get()) }
    single { provideNetworkHelper(androidContext()) }

    single<APIHelper> {
        return@single ApiHelperImpl(get())
    }
}

private fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
    OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()
} else OkHttpClient
    .Builder()
    .build()

private fun provideRetrofit(okHttpClient: OkHttpClient, BASE_URL: String): Retrofit =
    Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()

private fun provideApiService(retrofit: Retrofit): APIService = retrofit.create(APIService::class.java)

private fun provideNetworkHelper(context: Context) = NetworkHelper(context)