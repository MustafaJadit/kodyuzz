package com.kodyuzz.lib

import java.util.*
import kotlin.collections.HashMap

class MyClass {

}

fun main() {
    var hashtable = Hashtable<String, Int>()
    hashtable.put("k1", 23)
//    hashtable.put(null, 4)
    hashtable.put("k3", 84)
    hashtable.put("k4", 17)

    var hashMap = HashMap<String, Int>()
    hashMap.put("k1", 23)
//    hashMap.put(null, 73)
    hashMap.put("k4", 17)
    hashMap.put("k2", 12)

    println(hashtable)
    println(hashMap)


    var treeMap = TreeMap<String, Int>()
    treeMap.put("a", 1)
    treeMap.put("c", 2)
    treeMap.put("b", 3)
    println(treeMap)
}