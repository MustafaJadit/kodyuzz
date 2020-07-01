package com.kodyuzz.lib.codingchallenge

fun main() {
    var line = readLine()
    var split = line!!.split("")
    var result: String = ""
    for (character in split) {
        var lowerCharacter = character.toLowerCase()
        result += when (lowerCharacter) {
            "a" -> "@"
            "b" -> "8"
            "c" -> "("
            "d" -> "|)"
            "e" -> "3"
            "f" -> "#"
            "g" -> "6"
            "h" -> "[-]"
            "i" -> "|"
            "j" -> "_|"
            "k" -> "|<"
            "l" -> "1"
            "m" -> "[]\\/[]"
            "n" -> "[]\\[]"
            "o" -> "0"
            "p" -> "|D"
            "q" -> "(,)"
            "r" -> "|Z"
            "s" -> "\$"
            "t" -> "']['"
            "u" -> "|_|"
            "v" -> "\\/"
            "w" -> "\\/\\/"
            "x" -> "}{"
            "y" -> "`/"
            "z" -> "2"
            else -> character
        }
    }

    println(result)

}