package com.kodyuzz.lib.codingchallenge

fun main() {
    var myArray = arrayOf(2, 4, 5)
    println(minimumDivisor(myArray, 10))
}

fun minimumDivisor(arr: Array<Int>, threshold: Int): Int {
    // Write your code here
    var result=0
    for (divisor in 1..arr.max()!!) {
        var mySUm = 0L
        for (item in arr) {
            if (item % divisor != 0) {
                mySUm += (item / divisor) + 1
            } else {
                mySUm += (item / divisor)
            }
        }
        result=divisor
        if (mySUm <= threshold) break
    }
    return result
}