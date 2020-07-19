package com.kodyuzz.lib.codingchallenge

import java.util.*
import java.util.regex.Pattern

fun main() {

    getEventsOrder("abc", "cba", arrayOf("mo sa 45+2 Y", "a 13 G"), arrayOf("d 23 S f", "z 46 G")).forEach { println(it) }
}

fun getEventsOrder(team1: String, team2: String, events1: Array<String>, events2: Array<String>): Array<String> {
    // Write your code here

    var events1_ = events1.map { "$team1 $it" }.toTypedArray()
    var events2_ = events2.map { "$team2 $it" }.toTypedArray()
    val array = Array<String>(events1_.size + events2_.size) {
        ""
    }
    var treeMap = TreeMap<Int, String>()
    System.arraycopy(events1_, 0, array, 0, events1_.size)
    System.arraycopy(events2_, 0, array, events1_.size, events2_.size)
    for (item in array) {
        var compile = Pattern.compile("\\d+")
        var matcher = compile.matcher(item)
        while (matcher.find()) {
            treeMap.put(matcher.group().toInt(), item)
            break
        }

    }
    var arrayListOf = arrayListOf<String>()
    for ((k, v) in treeMap) {
        arrayListOf.add(v)
    }
    return arrayListOf.toTypedArray()
}
