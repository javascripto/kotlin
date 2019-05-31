
fun main(args: Array<String>) {
    val msg: String = "Hello World"
    val number: Int = 10 // Int, Short, Long, Byte, Double, Float (10.0f)

    println(msg)
    print(number.toShort().toInt().toLong().toByte().toDouble().toFloat().toString()) // Conversão de tipos
}
