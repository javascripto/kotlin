fun main() {
    val values = intArrayOf(*(1..15).toList().toIntArray())

    fun isEven(n: Int) = n % 2 == 0
    fun isGreatherThanFive(n: Int) = n > 5
    fun isMultipleOfThree(n: Int) = n % 3 == 0

    val (passed, failed) = values.testPredicate { isMultipleOfThree(it) }

    println("Passed: ${passed.contentToString()}")
    println("Failed: ${failed.contentToString()}")
}


inline fun IntArray.testPredicate(predicate: (Int) -> Boolean): PredicateSeparation {
    val passed = arrayListOf<Int>()
    val failed = arrayListOf<Int>()

    for (element in this)
        if (predicate(element)) passed.add(element)
        else failed.add(element)

    return PredicateSeparation(passed.toIntArray(), failed.toIntArray())
}

data class PredicateSeparation(
    val passed: IntArray,
    val failed: IntArray,
)
