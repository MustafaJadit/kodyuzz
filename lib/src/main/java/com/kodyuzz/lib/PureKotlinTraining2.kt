package com.kodyuzz.lib

fun main() {

//    forLoopNameDemo()

//    regularArrayDemo()

//    listDemo()

//    mapDemo()

//    defineLambda()

    printFunction()
}

fun defineLambda() {
    printFunction()
    myLambdaFunction2
    myLambdaFunction
    myLambdaFunction3
    println(myLambdaFunction4)
}

fun printFunction() {
    var tutorial = "This is Kotlin Tutorial"
    println(tutorial) //This is Kotlin Tutorial
    tutorial = run {
        val tutorial = "This is run function"
        println("this is run printing")
        tutorial
    }
}



val myLambdaFunction2: () -> Unit = {}

val myLambdaFunction: (String) -> Unit =
        { v ->
            println(v)
        }

val myLambdaFunction3: (String) -> Unit =
        { value2 ->
            String
            println(value2)
        }

val myLambdaFunction4: (s: String) -> Int =
        { g ->
            println()
            g.length
        }


fun mapDemo() {
    var hashMapOf = hashMapOf("a" to 1, "b" to 2)
    var mutableMapOf = mutableMapOf("a" to 2)
    var mapOf = mapOf("m1" to 1)
    var plus = mapOf.plus("b" to 2)
}

fun listDemo() {
    var listOf = arrayListOf("a", "b")
    var mutableListOf = mutableListOf("s1", "s2")
    var e = kotlin.collections.listOf<String>()
    var e2 = emptyList<String>()


}

fun regularArrayDemo() {
    var a1 = IntArray(3, { i -> i * 2 })
    var a2 = IntArray(3) { i -> i * 2 }
    a1.first()
    a1.last()
    a1.get(2)
    a1.set(1, 322)
    a1.sort()

}

fun forLoopNameDemo() {
    outer@ for (i in 1..10) {
        for (j in 'a'..'z') {
            if (j == 'v') continue@outer
            print(j + "\t")
        }
        println("-------------")
        println("-------------")
    }
}
