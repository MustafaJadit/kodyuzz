package com.kodyuzz.lib

import java.util.*
import kotlin.collections.HashMap

class MyClass {

}

fun main() {
//    mapTest1()

//    v2 = "this is v2, lol"
//    println(v2)

//    letOperation()

//    concatenationTest()

//    newLine()

//    checkAndCasting()

//    multipleCondition()

//    whenTest()

//    forTest()

//    coleectionTest()

//    splittingArrays()

//    varArgsTest()

//    println(quickFun())
//    println(quickFun2())

//    constructorTest()

//    dataClasstest2()

//    extensionFunction()

//    enumTest2()

//    sortList()

//    anonymousTest()

//    objectTest()

//    whenTest2()

//    constructorTest2()


}

fun constructorTest2() {
    var person = Person()
}

fun whenTest2() {
    var items = arrayListOf<String>("a", "b", "c", "d")
    for (item in items) {
//        var s = when (item) {
//            "o" -> "oooo"
//            "b" -> "bbb"
//            else -> " "
//        }
//        println(s)

        when {
            "c" in items -> println("ccccc")
            "d" in items -> println("ddddd")
        }



    }

}


class Person {

}

fun objectTest() {

    println(MyObject.name)
}

object MyObject {
    lateinit var name: String

    init {
        name = "scott"
    }
}

fun anonymousTest() {
    var value = object : MainActivityI {
        override fun getIndex() {
        }
    }

}

interface MainActivityI {
    fun getIndex();
}

fun sortList() {
    var listOf = listOf<Profile>(Profile(2, "two"), Profile(3, "three"), Profile(1, "one"))
    var sortedWith = listOf.sortedWith(kotlin.Comparator { o1, o2 ->
        if (o1.age > o2.age) return@Comparator 1
        if (o1.age < o2.age) return@Comparator -1
        return@Comparator 0
    })
    sortedWith.stream().forEach({ println(it.age) })

}

class Profile(var age: Int, var name: String) {}

fun enumTest2() {
    println(Direction.South.direction)

}

enum class Direction(direction: Int) {
    North(1)
    ,
    South(2)
    ,
    West(3)
    ,
    East(4);

    var direction: Int = -1

    init {
        this.direction = direction
    }

}

fun extensionFunction() {

    println(23.triple())
}

fun Int.triple() = this * 3

fun dataClasstest2() {
    var dev = Dev("java")
    var copy = dev.copy(experience = 3)
    var copy2 = copy.copy("kotlin")
    println(dev === copy)
}

data class Dev(val name: String, var experience: Int = 6) {}


class QA(private var name: String) {
    fun speak() {
        println(name)
    }
}

class Melon constructor(var size: Int) : Fruit("yellow") {

    constructor(sort: String) : this(23) {

    }

    fun ship(location: String) {

    }
}

open class Fruit(var color: String) {

}

fun constructorTest() {
    println(Utils.getName(23))
}


class Utils constructor() {

    companion object Companion1 {
        fun getName(value: Int): String {
            return when (value) {
                23 -> "twenty three"
                else -> "any other numbers"
            }
        }
    }

    init {
        println("this is init code block")
    }
}

fun quickFun(): Int = 23

fun quickFun2() = 87

fun varArgsTest(vararg num: Int) {
    println(num.size)
}

fun splittingArrays() {
    var (p, v) = "param=car".split("=")
    println(p)

}

private fun coleectionTest() {
    var listOf = mutableListOf<Int>(2, 5, 2)
//    var mapOf = mapOf<String, Int>("one" to 1, "three" to 3)
    for (number in listOf) {
        println(number)
    }
}


fun forTest() {

    for (i in 1..8) {

    }
}

fun whenTest() {
    var score = 4
    var any = when (score) {
        2 -> println(" two")
        in 3..5 -> "normal"
        6, 8 -> "nice"
        else -> "fail"
    }
    println(any)
}

fun multipleCondition() {
    for (score in 0..100 step 2)
        println(score)
}

fun checkAndCasting() {
    data class Car(var age: Int) {}
    data class Plane(var age: Int) {}

//    var car: Any = Plane(12)
    var car: Any? = null
    //if car is plane or null run the following block
    if (car is Plane?) {
        println("this is a plane")
        println(car?.age)
    } else {
        println("this is not a plane")
    }
//forcibly cast class
    var plane = car as? Plane
    println(plane?.age)
}


fun newLine() {
    println("""first line
        |second line
        |third line
    """.trimMargin())
}

fun concatenationTest() {
    val v1 = "mustafa"
    val age = 28
    var message = "my name is $v1 and I'm $age"
    println(message)
}

private fun letOperation() {
//    var s1: String
//    s1 = "yagma"
//    val let = s1.let {
//        val removePrefix = it.removePrefix("y")
//        removePrefix
//    }
//    println(let)

//    var x = "book"
//    x.let { outer ->
//        {
//            outer.substring(2).let {
//                println(it)
//            }
//        }
//    }
    //output: ok

//    var s1: String = "s1"
//    s1.apply {
//        var removePrefix = removePrefix("y")
//        //        println(removePrefix)
//        return
//    }

//    var v1: String = "yagma"
//    with(v1, {})

//    var v2 = "table"
//    var run = run {
//        val v3 = "sky"
//        v3
//    }
//    println(run)
//    //sky

//    data class Person(var name: String, var tutorial: String)
//    var person = Person("mustafa", "kotlin")
//    var also = person.also {
//        it.name = "osman"
////        println(it.name)
////        32
//    }
//    println(also)

    data class Person(var name: String, var tutorial: String)

    var person = Person("Anupam", "Kotlin")
    person.apply {
        tutorial = "Swift"
    }
    println(person)
}

private fun mapTest1() {
    var hashtable = Hashtable<String, Int>()
    hashtable.put("k1", 23)
//    hashtable.put(null, 4)
    hashtable.put("k3", 84)
    hashtable.put("k4", 17)

    var hashMap = HashMap<String, Int>()
    hashMap.put("k1", 23)
//    hashMap.put(null, 73)
    hashMap.put("k4", 17)
    hashMap.put("k2", 12)

    println(hashtable)
    println(hashMap)


    var treeMap = TreeMap<String, Int>()
    treeMap.put("a", 1)
    treeMap.put("c", 2)
    treeMap.put("b", 3)
    println(treeMap)
}

lateinit var v2: String


