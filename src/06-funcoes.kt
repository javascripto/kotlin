
fun main(args: Array<String>) {
    hello()
    echo("Resultado da soma: ${sum(2, 9)}")

    val list = listOf<Int>(1, 2, 3, 4, 5)

    val nMaiorQue3 = list.count({ n -> n > 3 }) // lambda

    println(nMaiorQue3)
}

fun sum(n1: Int, n2: Int): Int {
    return n1 + n2
}

fun sum(n1: Double, n2: Double): Double {
    return n1 + n2
}


fun hello() {
    println("Olá, Mundo!")
}

fun echo(string: String) {
    println(string)
}

