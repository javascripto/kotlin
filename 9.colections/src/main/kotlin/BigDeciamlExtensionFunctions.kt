import java.math.BigDecimal

// Extension function
fun Array<BigDecimal>.sum(): BigDecimal {
    return this.reduce { accumulator, item -> accumulator + item }
}

fun Array<BigDecimal>.average(): BigDecimal {
    return when(this.isEmpty()) {
        true -> BigDecimal.ZERO
        false -> this.sum() / this.size.toBigDecimal()
    }
}
