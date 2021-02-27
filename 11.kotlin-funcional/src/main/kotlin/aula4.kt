
// Funções de escopo: let, run, with, apply, also. takeIf, takeUnless


fun aula4() {
    val str = "Hello"

    str.let { println(it.length) }
    str.run { println(length) }

    val person = Person("Fulano", 30).apply {
        name = "John"
    }

    println(person)

    3.let end@ {
        if (it % 2 == 0) return@end "sim"
        "não"
    }.let(::println)



    with(person) {
        name = "Fulano"
        age = 20
    }
    run {
        person
    }
        .also {
            println(it)
        }
        .apply {
            age++
        }
        .let {
            it.age++
            it
        }.run {
            age++
            this
        }
        .let(::println)

    val n = 2

    n.takeIf { it % 2 == 0 }.let(::println) // n (2)
    n.takeUnless { it % 2 == 0 }.let(::println) // null

}

fun main() {
    aula4()
}


// Object.prototype.let = function(blockFn) {
//   return blockFn(this)
// }
//Object.prototype.run = function(blockFn) {
//    return blockFn.apply(this)
//}
//Object.prototype.apply = function(blockFn) {
//    blockFn.apply(this)
//    return this
//};

data class Person(var name: String, var age: Int)