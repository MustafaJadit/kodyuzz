package com.kodyuzz.tafa.student

import java.util.function.Function
import java.util.function.Predicate
import java.util.function.Supplier


fun test2() {

    for ((k, v) in hashMapOf<String, Int>("a" to 1, "man" to 3, "bee" to 2))
        println("$k and $v")
}

fun test1() {

    var let = "".let {
        23
    }

    data class Head(var name: String, var age: Int) {}

    var head = Head("a", 23)
    var (name, age) = Head(age = 23, name = "tyler")
    head.copy()
    head.copy("b")


    var sortedWith = listOf<String>("cdd", "abc", "abb").sortedWith(object : Comparator<String> {
        override fun compare(p0: String?, p1: String?): Int {
            return if (p0.hashCode() > p1.hashCode()) {
                1
            } else if (p0.hashCode() < p1.hashCode()) -1
            else 0
        }

    })

//    sortedWith.forEach { println(it) }
    sortedWith.forEach(::println)

    println("--------------------")
//    for (i in sortedWith.indices) println(sortedWith.get(i).toUpperCase())
    for (i in sortedWith.indices) println(i)
    println("--------------------")
    for (i in sortedWith) println(i)

}

enum class Week private constructor(var num: Int = 0) {
    MONDAY(1), TUESDAY(2);


    init {
        println("this is a constructor")
    }

}

fun test4() {
    var monday = Week.MONDAY
    println(monday.num)
    println(monday.name)
//    var tuesday = Week.TUESDAY
//
//    println(tuesday.name)

}


fun test5() {

    outer@ for (i in 1..10) {
        innner@ for (j in 1..10) {
            if (i == 4) continue@outer
        }
    }
}

class Space {
    fun test() {
        Space@ this.test()
    }
}

fun test6() {
    val myLambda1: Function<String, Int>
    myLambda1 = Function { a -> a.length }

    //accept
    fun inner2(consumer: () -> Unit) {

    }

    //get
    fun inner3(supplier: Supplier<Int>) {}

    //test
    fun inner4(p: Predicate<String>) {}

    //apply
    fun inner5(f: Function<String, Int>) {}


    val myLambdaFun2: (s: String) -> Int = {
        println("dd")
        println(it)
        it.length
    }


}

abstract class Light {
    abstract var strength: Int
}

class MicroLight : Light() {

    var color: String = ""
        get() = field
        set(value) {
            field = value
        }

    override var strength: Int = 1
        get() {
            println("getting")
            return field
        }
        set(value) {
            println("setting")
            if (value > 99) field = (value.toString() + " Big").hashCode()
        }
//    override var strength = 34
}

fun test7() {
    var microLight = MicroLight()
    println(microLight.strength.toString())
    microLight.strength = 8
    println(microLight.strength.toString())
}

fun test8() {
    var block: Tank.() -> Unit = {
        name = "b"
        //in apply it doesn't return anything but current obj
        //so following obj couldn't get returned
        "bb"
        Tank("b0")
    }

    var block2: Tank.() -> Unit = {
        name = "b"
        //in apply it doesn't return anything but current obj
        //so following obj couldn't get returned
        "bb"
        Tank("b10")
    }
    var appliedTank = Tank("a").apply(block)
    println(appliedTank)

    println("==========")
    var alsoTank = Tank("a2").also(block2)
    println(alsoTank)

    println("-------------")
    var apply = "abcde".apply {
        println(length)
        substring(1)
    }
    println(apply)

    println("-------------")
    var also = "abcde".also {
        println(it.length)
        it.substring(2)
    }
    println(apply)

    println("-------------")
    var apply1 = Tank("t1").apply {
        println(name)
        color = "green"
    }
    println(apply1)

    println("-------------")
    var also1 = Tank("t1").also {
        println(it.name)
        it.color = "purple"
        Tank("name2")
    }
    println(also1)

    println("----------")
    println(with(Tank("name2")) {
        name = "name3"
        with(Tank("name4")) {
            32
        }

    })

    println("-----------")
    "".run {

    }

    println("---------")
    var run = run {
        println("dd")

    }

    println("=-=------")
    println("l1234".let {
        println(it.length)
        it.substring(2)
        "nnn"
    })


}

data class Tank(var name: String, var color: String = "brown") {}

fun main() {
//    test1()
//    test2()
//    test4()
//    test6()
//    test7()
    test8()
}