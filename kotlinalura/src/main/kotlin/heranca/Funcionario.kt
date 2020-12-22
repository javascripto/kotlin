package heranca

open class Funcionario(
    val nome: String,
    val cpf: String,
    val salario: Double,
) {
    open val bonificacao get() = salario * 0.1

    override fun toString(): String {
        return "{" +
            "\"nome\": \"$nome\"," +
            "\"cpf\":\"$cpf\"," +
            "\"salario\":$salario," +
            "\"bonificacao\":$bonificacao" +
        "}"
    }
}

fun main() {
    val funcionario = Funcionario("Roberto", "12345678901", 7200.0)
    println(funcionario)
}