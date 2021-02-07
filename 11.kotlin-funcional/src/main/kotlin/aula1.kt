
fun safeDivider(numerator: Int, denominator: Int) =
    if (denominator == 0) 0.0 else numerator.toDouble() / denominator

// function types
val f: (Int, Int) -> Double = ::safeDivider

val myFunc: () -> Unit = fun() = println("myFunc")

class Teste: () -> Unit {
    override fun invoke() {
        println("Executa invoke do Teste")
    }
}

val funcaoClasse: () -> Unit = Teste()

val minhaFuncaoLambda: () -> Unit = {}

val lambda = { println("lambda") }
val lambda2 = fun (x: Int) = x * 2

fun aula1() {
    f(10, 4).let(::println)
    myFunc()
    funcaoClasse()
    minhaFuncaoLambda()
    lambda()
    lambda2(3).let(::println)
}

fun main() {
    aula1()
}
