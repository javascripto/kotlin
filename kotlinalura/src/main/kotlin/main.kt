

fun main() {
    val f = heranca.Funcionario("asd", "asd", 123.1)
    println(f)
	// data class ganha a implementaçao do equals

    val maria = Analista(2.3)
}

open class Funcionario(open var bonificacao: Double)
class Gerente(var bonificacao: Double)
class Analista(override var bonificacao: Double): Funcionario(bonificacao)



