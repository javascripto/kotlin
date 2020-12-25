import java.math.BigDecimal
import java.math.BigInteger

fun main() {
    println(getNumberType(123))
    println(getNumberType(3.14))
    println(getNumberType(3.14f))
    println(getNumberType(312319912989128391))
}

fun getNumberType(number: Number): String {
    return when(number) {
        is Int -> "Inteiro"
        is Double -> "Double"
        is Float -> "Float"
        is Long -> "Long"
        is Short -> "Short"
        is Byte -> "Byte"
        is BigInteger -> "BigInteger"
        is BigDecimal -> "BigDecimal"
        else -> """¯\(°_o)/¯ Não sei ¯\_(ツ)_/¯"""
    }
}
