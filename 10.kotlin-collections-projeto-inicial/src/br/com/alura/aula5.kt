package br.com.alura

fun main() {
    aula5()
}

fun aula5() {
    val listaDePedidos = listOf<Pedido>(
        Pedido(1, 20.0),
        Pedido(2, 60.0),
        Pedido(3, 30.0),
        Pedido(4, 70.0)
    )
    val pedidosMapeados = listaDePedidos.associate { Pair(it.numero, it) }

    listaDePedidos.associateBy { it.numero }.let(::println)
    listaDePedidos.associateWith { it.valor > 30.0 }.let(::println)

    val pedidosAgrupadosPorPrecoMaiorQue50: Map<Boolean, List<Pedido>> = listaDePedidos.groupBy { it.valor > 50.0 }
    val pedidosFreteGratis = pedidosAgrupadosPorPrecoMaiorQue50[true]

    val (freteGratis, fretePago) = listaDePedidos.partition { it.valor > 50 }

    println(freteGratis == pedidosFreteGratis)

}

data class Pedido(val numero: Int, val valor: Double)