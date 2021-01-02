import java.math.BigDecimal
import java.math.RoundingMode

fun main() {
//    series()
//    metodosAgregadores()
//    arrayGenerico()
//    arrayBigDecimalComVarArgs()
}


fun series() {
    val serie1 = 1.rangeTo(10)
    val serie2 = 1..10
    val serie3 = 1.until(10) // 10 not included (1..9)
    val serie4 = 1.until(10) step 2 // 1..9 step 2
    val serie5 = 10 downTo 0
    val seriePares = 0..10 step 2

    println(serie1)
    println(serie2)
    println(serie3)
    println(serie4)
    println(serie5)

    println("Included: ${5 in serie1}")
    println("Included: ${serie1.contains(5)}")
    println("Random: ${serie1.random()}")

    // ClosedFloatingPointRange
    println((0.0..10.0).contains(Math.PI))

    for (item in seriePares) print("$item ")
}

fun metodosAgregadores() {
    val idades = intArrayOf(8, 27, 15, 38, 10, 19, 22)
    println("Maior idade: ${idades.maxOrNull()}")
    println("Menor idade: ${idades.minOrNull()}")
    println("Algum adulto: ${idades.any { it >= 18 } }")
    println("Alguema criança: ${idades.any { it >= 18 } }")
    println("Todos adultos: ${idades.all { it >= 18 } }")
    println("Apenas crianças na lista: ${idades.filter { it < 18}}")
    println("Primeiro adulto: ${idades.find { it >= 18}}")
    println("Quantidade de adultos: ${idades.count { it >= 18 } }")
    println("Média de idades: ${idades.average().toInt() }")
}

fun arrayGenerico() {
    val salarios = Array<BigDecimal>(5) { BigDecimal.ZERO }
    salarios[0] = BigDecimal("2800")
    salarios[1] = "1500".toBigDecimal()
    salarios[2] = "3200".toBigDecimal()
    salarios[3] = BigDecimal("7200")
    salarios[4] = BigDecimal("5200")

    val aumentos: List<BigDecimal> = salarios.map { salario -> salario.times(BigDecimal("1.2")) }

    println("Salários: ${salarios.contentToString()}")
    println("Aumento: $aumentos")
}

fun arrayBigDecimalComVarArgs() {
    val salarios = bigDecimalArrayOf("2800.79", "1499.98", "3200.0", "7200.28", "5200.12")

    val dezPorcento = "1.1".toBigDecimal()

    val novosSalarios = salarios
        .map { calcularAumentoSalario(it, dezPorcento) }
        .toTypedArray()

    println("Salários: ${salarios.contentToString()}")
    println("Novos salários: ${novosSalarios.contentToString()}")
}

// Ctrl + Alt + M = Extrair codigo para função

fun arredondaParaCima(numero: BigDecimal): BigDecimal {
    return numero.setScale(2, RoundingMode.UP)
}

fun calcularAumentoSalario(salario: BigDecimal, aumento: BigDecimal): BigDecimal {
    val cincoMil = "5000".toBigDecimal()
    val quinhentos = "500".toBigDecimal()
    return if (salario < cincoMil) salario + quinhentos
    else arredondaParaCima(salario * aumento)
}

fun bigDecimalArrayOf(vararg valores: String): Array<BigDecimal> {
    return Array(valores.size) {
        index -> valores[index].toBigDecimal()
    }
}
