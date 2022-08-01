package com.aptivist.compose.domain

import com.aptivist.compose.data.AnimalDTO

class Animal(
        val animal_type: String,
        val id: Int,
        val image_link: String,
        val name: String,
)

fun AnimalDTO.toAnimal() : Animal {
    return Animal(this.animal_type, this.id, this.image_link, this.name)
}