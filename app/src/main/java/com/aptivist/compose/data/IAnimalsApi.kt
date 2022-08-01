package com.aptivist.compose.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface IAnimalsApi {

    @GET("animals/rand/{number}")
    suspend fun getAnimalsByQty(@Path("number") number: Int) : Response<List<AnimalDTO>>

}