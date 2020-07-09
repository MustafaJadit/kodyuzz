package com.kodyuzz.lib

import java.util.*
import java.util.stream.Collectors
import java.util.stream.Stream

fun test() {
    var mutableListOf = mutableListOf<String>("a", "g", "b", "z", "c")
    var map = mutableListOf.stream().map {
        println(it)
        it.hashCode() + "!!".hashCode()
    }

//    println(map.count())

    var collect = map.collect(Collectors.toSet())


//    map.forEach(::println)
}

fun test2() {
    val list: List<String> = Arrays.asList("Geeks", "GFG",
            "GeeksforGeeks", "gfg")

    list.stream().flatMap { str: String -> Stream.of(str[2], str[1]) }.forEach { println(it) }


//    list.stream().map<Any> { str -> str[2] }.forEach { x: Any? -> println(x) }
}

fun main() {
    test2()
}