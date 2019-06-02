
fun main(args: Array<String>) {

    print("Digite o primeiro número: ")
    var n1 = readLine()!!.toDouble()

    print("Digite o segundo número: ")
    var n2 = readLine()!!.toDouble()

    print("Qual operação deseja realizar? (+, -, *, /) ")
    val op: String = readLine()!!

    val result = when (op) {
        "+" -> n1 + n2
        "-" -> n1 - n2
        "*" -> n1 * n2
        "/" -> n1 / n2
        else -> "Operação inválida"
    }

    println("O resultado da operação é: $result")
}
