
fun main() {
    val n1 = 10
    val n2 = 10.5

    val max = if (n1 > n2) n1 else n2 // "ternário"

    if (n1 < n2) {
        println("$n1 é menor que $n2")
    } else if (n1 > n2) {
        println("$n2 é maior que $n2")
    } else {
        println("$n2 e $n2 são iguais")
    }

    println(n1 + n2)
    println("O número maior é $max")

    when (2) { // "switch"
        1 -> println("Um")
        2 -> println("Dois")
        3 -> println("Três")
        else -> {
            println("Zero")
        }
    }
}
