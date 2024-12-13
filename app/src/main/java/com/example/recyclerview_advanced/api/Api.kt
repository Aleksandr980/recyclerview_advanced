package com.example.recyclerview_advanced.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("/api/character")
    suspend fun character(
        @Query("page") page: Int
   // ): CharacterPagedListDto1
    ):Response
}

val retrofit: Api = Retrofit
    .Builder()
    .client(
        OkHttpClient.Builder().addInterceptor(
            HttpLoggingInterceptor().also {
                it.level = HttpLoggingInterceptor.Level.BODY
            }).build()
    )
    .baseUrl("https://rickandmortyapi.com")
    .addConverterFactory(GsonConverterFactory.create())
    .build()
    .create(Api::class.java)


data class Response(
    val results: List<Character>
)

data class Character(
    val id: Long,
    val name: String,
    val status: String,
    val species: String,
    val image: String,
    val origin: Origin,
    val location: Location
)

data class Origin(
    val name: String
)

data class Location(
    val name: String
)

