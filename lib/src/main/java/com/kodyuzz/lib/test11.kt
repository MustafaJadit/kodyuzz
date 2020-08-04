package com.kodyuzz.lib

fun main() {
    isReversedString(arrayOf("321", "6", "321"))
}

fun isReversedString(arg: Array<String>) {
    var reversed: Array<String?> = Array(arg.size) { null }
    var isMatched = true
    for (index in arg.indices) {
        if (arg[index] != arg[arg.size - index - 1]) {
            isMatched = false
            break
        }
    }
    arg.forEach { print("$it ") }
    println()
    reversed.forEach { print("$it ") }
    println(isMatched)

}
