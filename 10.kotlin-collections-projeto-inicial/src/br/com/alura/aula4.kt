package br.com.alura

fun aula4() {
    val pedidos: MutableMap<Int, Double?> = mutableMapOf(
        Pair(1, 20.0),
        Pair(2, 34.0),
        3 to 50.0,
        4 to null
    )

    pedidos
        .mapNotNull { it.value }
        .reduce { total, value -> total + value  }
        .let { println("Total: $it")}

    pedidos
        .filter { (key, value) ->
            key % 2 == 0 && value != null && value > 30.0
        }
        .let(::println)

    pedidos.getValue(4).let(::println)
    pedidos.getOrElse(4, {
        "Não encontrado"
    }).let(::println) // se o valor for nulo, retorna valor retornado da closure
    pedidos.getOrDefault(0, 0.0).let(::println) // se a chave nao existir retorna valor default

    println(pedidos.keys)
    println(pedidos.values)
    println(pedidos)

    (pedidos + (5 to 20.4) + Pair(6, 90.3) - 1 - 2).let(::println)
}

fun main() {
    aula4()
}

fun Any.isNull() = null == this
fun Any.isNotNull() = !this.isNull()
