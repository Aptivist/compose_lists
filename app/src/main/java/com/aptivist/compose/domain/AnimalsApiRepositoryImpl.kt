package com.aptivist.compose.domain

import com.aptivist.compose.data.IAnimalsApi
import javax.inject.Inject

class AnimalsApiRepositoryImpl @Inject constructor(val animalsApi:IAnimalsApi) : IAnimalsApiRepository {

    override suspend fun getAnimalsByQty(qty: Int): List<Animal> {
       return animalsApi.getAnimalsByQty(qty).body()?.map {
           it.toAnimal()
       } ?: listOf()
    }
}