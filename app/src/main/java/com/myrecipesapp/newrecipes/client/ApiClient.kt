package com.myrecipesapp.newrecipes.client

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    val apiClientInstance: RecipesandDriksApis by lazy { get().create(RecipesandDriksApis::class.java) }
    val apidrinkInstance : RecipesandDriksApis by lazy { getDrinks().create(RecipesandDriksApis::class.java) }
    private val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val okHttp = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()

    private fun get(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://www.themealdb.com/")
            .client(okHttp).build()
    }
    private fun getDrinks():Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://www.thecocktaildb.com/")
            .client(okHttp).build()
    }
}