// Extension function com receiver (this)   no lugar do objeto de escopo (it)

fun aula5() {
    soma(1, 2) { println(it) }
    somaReceiver(1, 2) { println(this) }
    somaReceiver2(1, 2) { println(this) }
    somaReceiver3(1, 2) { resultado: String ->
        println(resultado)
        println(this)
    }
}

fun soma(a: Int, b: Int, resultado: (Int) -> Unit) {
    resultado(a + b)
}

fun somaReceiver(a: Int, b: Int, resultado: Int.() -> Unit) {
    resultado(a + b)
}

fun somaReceiver2(a: Int, b: Int, resultado: Int.() -> Unit) {
    (a + b).resultado()
}

fun somaReceiver3(a: Int, b: Int, resultado: Int.(String) -> Unit) {
    val soma = a + b
    soma.resultado("Resultado: $soma")
}

fun main() {
    aula5()
}