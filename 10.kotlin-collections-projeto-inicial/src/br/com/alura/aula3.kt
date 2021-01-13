package br.com.alura

fun main() {
    val weekDays = mutableMapOf<Int, String>(
        Pair(0, "Domingo"),
        Pair(1, "Segunda"),
        2 to "Terça", // infix function são menos performáticos do que a classe diretamente Pair
        3 to "Quarta"
    )
    weekDays.put(4, "Quinta")
    weekDays.put(5, "Sexta")
    weekDays[6] = "Sábado"
    weekDays.putIfAbsent(6, "[Sábado]")


    println(weekDays)
    println(weekDays.get(0))

    println("Tamanho: ${weekDays.size}")

    for ((key, day) in weekDays) {
        print("$day ")
    }
    println()

    for (entry: Map.Entry<Int, String> in weekDays) {
        println("${entry.key}: ${entry.value}")
    }

}