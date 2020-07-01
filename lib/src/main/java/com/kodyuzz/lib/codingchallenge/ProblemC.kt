package com.kodyuzz.lib.codingchallenge
fun main(args: Array<String>) {

    var number = args
    if (number.isEmpty()) {
        number = Array(32) { "?" }
    }

    var outputStringBuilder: ArrayList<java.lang.StringBuilder> = arrayListOf<java.lang.StringBuilder>()

    var operationCount = readLine();
    while (operationCount != null) {
        if (operationCount.toInt() == 0) {
            for (stringBuilder in outputStringBuilder) {
                println(stringBuilder)
            }
            return
        }
        for (i in 1..operationCount.toInt()) {
            var newLine = readLine()
            var operation = newLine!!.split(" ")
            when {
                operation[0].equals("SET") -> {
                    var index = operation[1].toInt()
                    number.set(number.size - index - 1, "1")
                }
                operation[0].equals("CLEAR") -> {
                    var index = operation[1].toInt()
                    number.set(number.size - index - 1, "0")
                }
                operation[0].equals("AND") -> {
                    var indexI = operation[1].toInt()
                    var indexJ = operation[2].toInt()
                    if (!number[number.size - indexI - 1].equals("?") and !number[number.size - indexJ - 1].equals("?")) {
                        var resultOfBoolean = (number[number.size - indexI - 1]).toInt() and (number[number.size - indexJ - 1]).toInt()
                        number[number.size - indexI - 1] = resultOfBoolean.toString()
                    } else {
                        number[number.size - indexI - 1] = "?"
                    }
                }
                operation[0].equals("OR") -> {
                    var indexI = operation[1].toInt()
                    var indexJ = operation[2].toInt()
                    if (!number[number.size - indexI - 1].equals("?") and !number[number.size - indexJ - 1].equals("?")) {
                        var resultOfBoolean = (number[number.size - indexI - 1]).toInt() or (number[number.size - indexJ - 1]).toInt()
                        number[number.size - indexI - 1] = resultOfBoolean.toString()
                    } else {
                        number[number.size - indexI - 1] = "?"
                    }

                }
                else -> {
                    // throw exception or do nothing
                }
            }

        }

        var sb: StringBuilder = java.lang.StringBuilder()
        for (element in number) {
            sb.append(element)
        }
        outputStringBuilder.add(sb)
        number = Array(32) { "?" }
        operationCount = readLine()
    }
}
