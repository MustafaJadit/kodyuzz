package com.kodyuzz.lib.codingchallenge

fun main() {

    var array = arrayOf(arrayOf(0, 2), arrayOf(1, 5), arrayOf(0, 9), arrayOf(2, 15))
    println(slowestKey(array))

}


fun slowestKey(array: Array<Array<Int>>): Char {
    // Write your code here
    var speed = 0
    var saveIndex = 0
    for (itemIndex in array.indices) {
        if (itemIndex == 0) continue
        var rightElement = array[itemIndex][1]
        var leftElement = array[itemIndex - 1][1]
        if (rightElement - leftElement > speed) {
            speed = rightElement - leftElement
            saveIndex = itemIndex
        }
    }
    var i = array[saveIndex][0]

    return (i + 97).toChar()
}

fun int2Char(num: Int): Char {
    var result: Char = 'a'
    for (i in 0..25) {

    }
    return result;
}