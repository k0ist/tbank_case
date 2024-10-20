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
    fun idAnimal(breed: String, weight: Double, age: Int): Animal? {
        return when (breed.lowercase(Locale.getDefault())) {
            "husky" -> Husky(weight, age)
            "corgi" -> Corgi(weight, age)
            "scottish" -> ScottishCat(weight, age)
            "siamese" -> SiameseCat(weight, age)
            else -> null
        }
    }
}


fun isAnimal(animal: Animal?): String {
    return when(animal) {
        is Dog -> " - это собака"
        is Cat -> " - это кошка"
        else -> " ,мы не знаем, что это такое"
    }
}

fun main() {
    val petShop = PetShop()
    val hu = petShop.idAnimal("husky", 30.0, 12)
    val co = petShop.idAnimal("COrgi", 12.0, 5)
    print(co)
    println(isAnimal(co))
    print(hu)
    println(isAnimal(hu))
    val sc = petShop.idAnimal("scOttish", 30.0, 12)
    val si = petShop.idAnimal("SIAMESE", 12.0, 5)
    print(sc)
    println(isAnimal(sc))
    print(si)
    println(isAnimal(si))
}