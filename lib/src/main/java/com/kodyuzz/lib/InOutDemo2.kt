package com.kodyuzz.lib

interface Produce< out T>{
    fun produce():T

}

interface Consume<in T>{
    fun consume(t:T)
}

open class Food{}

open class FastFood :Food(){}

class InOutBurger:FastFood(){}

class FoodStore:Produce<Food>{
   override fun produce():Food{
        return Food()
    }


}

class FastFoodStore:Produce<FastFood>{
    override fun produce(): FastFood {
        return FastFood()
    }

}

class InOutDemo:Produce<InOutBurger>{
    override fun produce(): InOutBurger {
        return InOutBurger()
    }


}


class Human:Consume<Food>{
    override fun consume(t: Food) {
        println(t.javaClass.name)

    }
}

class ModernPeople: Consume<FastFood>{
    override fun consume(t: FastFood) {
        println(t.javaClass.name)
    }
}

class American :Consume<InOutBurger>{
    override fun consume(t: InOutBurger) {
        println(t.javaClass.name)

    }
}

fun main() {
    var foodStore:Produce<Food> = FoodStore()
    var fastFoodStore:Produce<Food> = FastFoodStore()
    println(foodStore.produce().javaClass.name)
    println(fastFoodStore.produce().javaClass.name)

    var human:Consume<InOutBurger> = Human()
    var modernPeople:Consume<InOutBurger> = ModernPeople()
    human.consume(InOutBurger())
    modernPeople.consume(InOutBurger())
}