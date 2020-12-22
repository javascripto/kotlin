package heranca

class Diretor(
    nome: String,
    cpf: String,
    salario: Double
) : Funcionario(nome, cpf, salario) {
    override val bonificacao get() = salario * 0.3
}

fun main() {
    val funcionario: Funcionario = Diretor("Roberto", "12345678901", 7200.0)
    println(funcionario)
}
