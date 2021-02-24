
interface ISomador : (Int, Int) -> Int

class Somador : ISomador {
    override fun invoke(p1: Int, p2: Int): Int {
        return p1 + p2
    }
}

val somar : ISomador = Somador()


val minhaFuncaoLambdaComParametros: (Int, Int) -> Int = { x, y -> x + y }

val minhaFuncaoLambdaTipadaPorInferencia = { x: Int, y: Int -> x + y }

// label de retorno em lambdas
val calculaBonificacao: (salario: Double) -> Double = retorna@ { salario ->
    if (salario > 1000.0)
        return@retorna salario + 50.0
    salario + 100.0
}

fun aula2() {
    Somador()(3, 5).let(::println)
    somar(3, 6).let(::println)

    println(minhaFuncaoLambdaComParametros(3, 4))
    println(minhaFuncaoLambdaTipadaPorInferencia(8, 9))
    println(calculaBonificacao(1001.0))
    println(calculaBonificacao(900.0))
}

fun main() {
    aula2()
}