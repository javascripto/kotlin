
fun main() {
    `soma com extension function reduce e fold`()
    `média dos 3 maiores salários`()

//    bigDecimalArrayOf("4.0", "3", "10").average().let(::println)
}

fun `soma com extension function reduce e fold`() {
    val bigDecimals = bigDecimalArrayOf("0.1", "0.2")
    val (x, y) = bigDecimals

    println("Somatório Double:             ${0.1 + 0.2}")
    println("Somatório Bigdecimal:         ${bigDecimals.sum()}")

    val valorInicial = "1".toBigDecimal()

    // fold é como o reduce porém com valor inicial
    val somatorioComValorInicial = bigDecimals.fold(valorInicial) { acc, it -> acc + it }

    println("Somatorio com valor inicial:  $somatorioComValorInicial")
}

fun `média dos 3 maiores salários`() {
    val salarios = bigDecimalArrayOf("2800.79", "1499.98", "3200.0", "7200.28", "5200.12")

    val mediaDos3maioresSalarios = salarios
        .sorted()
        .takeLast(3).toTypedArray()
        .average()

    println("Média dos 3 maiores salários: $mediaDos3maioresSalarios")
}
