package com.kodyuzz.lib.codingchallenge

fun main(args: Array<String>) {
    var line = readLine();
    while (line != null) {
        var a = line.toString().trim()
        var count: Int = 0
        if (a == "-1") {
            return
        } else count = a.toInt()

        var s = arrayListOf<Int>()
        var t = arrayListOf<Int>()
        var miles: Int = 0
        for (index in 0 until count) {
            var pair = readLine()
            var (speed, time) = pair!!.split(' ')
            s.add(speed.toInt())
            t.add(time.toInt())
            if (index == 0) {
                miles += (speed.toInt() * time.toInt())
            } else {
                var time = t.get(index) - t.get(index - 1)
                miles += (time * s.get(index))
            }


        }

        println("$miles miles")


        line = readLine();
    }
}