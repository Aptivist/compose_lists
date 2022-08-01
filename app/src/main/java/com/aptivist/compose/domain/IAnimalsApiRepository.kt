package com.aptivist.compose.domain

interface IAnimalsApiRepository {

    suspend fun getAnimalsByQty(qty: Int) : List<Animal>

}