package heranca

class Gerente(
    nome: String,
    cpf: String,
    salario: Double
) : Funcionario(nome, cpf, salario) {
    override val bonificacao get() = super.bonificacao + salario
}

fun main() {
    val funcionario: Funcionario = Gerente("Roberto", "12345678901", 7200.0)
    println(funcionario)
}
