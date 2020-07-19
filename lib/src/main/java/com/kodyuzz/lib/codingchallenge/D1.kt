package com.kodyuzz.lib.codingchallenge

fun fizzBuzz(n: Int): Unit {
    // Write your code here
    for (i in 1..n) {
        if (i % 3 == 0 && i % 5 == 0) {
            println("FizzBuzz")
        } else if (i % 3 == 0) {
            println("Fizz")
        } else if (i % 5 == 0) {
            println("Buzz")
        } else {
            println("$i")
        }
    }


}

fun main() {

//    val n = readLine()!!.trim().toInt()

    fizzBuzz(15)
}
