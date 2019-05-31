
fun main() {
    // for, while, do, Array, Mutable Map

    val typedArray: Array<Int> = arrayOf(1, 2, 3, 4, 5)
    val mixedArray = arrayOf(false, 1, 2.0, 3.0f, "4", 5.toByte())

    for (item in mixedArray) {
        println(item)
    }

    var i = 0; val length = typedArray.count()
    while (i < length)
        println(typedArray[i++])

    // Mutable map
    println("Mutable Map")

    val map = mutableMapOf<Int, Any>()

    map.put(1, "Yuri")
    map[2] = 2.0

    for (item in map) println("${item.key} = ${item.value}")

    for (item in map) println(item)

    println("do while")
    var x = 0
    do println(++x) while (x < 10)
}
