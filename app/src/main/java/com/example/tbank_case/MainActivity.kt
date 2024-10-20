package com.example.tbank_case

import java.util.Locale


interface Animal {
    val weight: Double
    val age: Int
}


enum class Bite {
    STRAIGHT,
    OVER,
    UNDER
}


enum class Behavior {
    ACTIVE,
    PASSIVE
}

interface Dog: Animal {
    val bite: Bite
}


interface Cat: Animal {
    val behavior: Behavior
}


data class Husky(override val weight: Double, override val age: Int) : Dog {
    override val bite = Bite.STRAIGHT
}


data class Corgi(override val weight: Double, override val age: Int) : Dog {
    override val bite = Bite.UNDER
}


data class ScottishCat(override val weight: Double, override val age: Int) : Cat {
    override val behavior = Behavior.PASSIVE
}


data class SiameseCat(override val weight: Double, override val age: Int) : Cat {
    override val behavior = Behavior.ACTIVE
}


class PetShop {
    fun idAnimal(breed: String): String {
        return when (breed.lowercase(Locale.getDefault())) {
            "husky" -> "Dog"
            "corgi" -> "Dog"
            "scottish" -> "Cat"
            "siamese" -> "Cat"
            else -> "Unknown animal"
        }
    }
}


fun main() {

}