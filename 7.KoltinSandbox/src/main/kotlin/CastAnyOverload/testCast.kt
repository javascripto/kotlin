package CastAnyOverload

// Sobrecarga de métodos e polimorfismo com ANy

// O tipo Any do Kotlin em tempo de execução é exatamente o tipo Object do Java

fun main() {
    echo("Olá, Mundo!")
    echo(123)
    echo(3.14)
    echo(true)
    echo(null)
    echo()
    val objeto: Any = java.lang.Object()
}

fun echo() {
    println("Null: null")
}

fun echo(text: Int) {
    println("Int: $text")
}

fun echo(text: String) {
    println("String: $text")
}

fun echo(text: Any?) {
    println("Any: $text")
}

fun teste(arg: Any): Any {
    return when (arg) {
        is Int -> "Int: $arg"
        is Double -> "Double: $arg"
        else -> "Any: $arg"
    }
}

interface ComBonificacao {
    fun bonificacao(): Int
}

fun castWithAsAndSmartCastWithIs(funcionario: Any): Int {
    if (funcionario is ComBonificacao) {
        return funcionario.bonificacao()
    }
    // (funcionario as ComBonificacao).bonificacao()
    return 0
}

fun smartCastWithWhen(objeto: Any): String {
    return when(objeto) {
        is Int -> "Inteiro"
        is Double -> "Real"
        is String -> "String"
        is ComBonificacao -> "Com bonificação ${objeto.bonificacao()}"
        else -> "Outro tipo"
    }
}
