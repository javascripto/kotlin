package br.com.alura


fun main() {
    val fizeramCursoAndroid = mutableSetOf("Alex", "Fran", "Gui", "Maria")
    val fizeramCursoKotlin = listOf("Alex", "Paulo", "Maria")

    val fizeramAmbos = mutableListOf<String>()
    fizeramAmbos.addAll(fizeramCursoAndroid)
    fizeramAmbos.addAll(fizeramCursoKotlin)

    val fizeramAmbosCursos = fizeramCursoAndroid + fizeramCursoKotlin // join de listas com operador +
//    o objeto que invoca o metodo plus define o tipo do retorno
//    set.plus(list) = Set
//    set + list = Set
//    list + set = List

    println(fizeramAmbos.distinct()) // remove ocorrencias repetidas
    println(fizeramAmbosCursos) // não precisa do distinct pois o resultado do plus é um set

    val conjuntoFizeramAmbos: MutableSet<String> = mutableSetOf<String>()
    conjuntoFizeramAmbos.addAll(fizeramCursoAndroid)
    conjuntoFizeramAmbos.addAll(fizeramCursoKotlin)

    println(conjuntoFizeramAmbos)

    // intersect
    println(listOf(1, 2, 3, 4) intersect listOf(3, 4, 5, 6)) // 3, 4

    // union
    println(listOf(1, 2, 3) union listOf(3, 4, 5)) // 1, 2, 3, 4, 5 // infix function que pode ser usada como metodo ou operador binario
    println(listOf(1, 2, 3).union(listOf(3, 4, 5))) // 1, 2, 3, 4, 5
    println((listOf(1, 2, 3, 4) + listOf(3, 4, 5)).toSet()) // 1, 2, 3, 4, 5
    println(listOf(1, 2, 3).plus(listOf(3, 4, 5)).toSet()) // 1, 2, 3, 4, 5

    // subtract
    println(listOf(1, 2, 3, 4, 5, 6) subtract listOf(4, 5, 6)) // 1, 2, 3
    println(listOf(1, 2, 3, 4, 5, 6) - listOf(4, 5, 6)) // 1, 2, 3
}

data class Numero(val n: Int) {
    operator fun plus(other: Numero): Numero {
        return Numero(this.n + other.n)
    }
}

// operator overload
// https://kotlinlang.org/docs/reference/operator-overloading.html
fun operatorPlus() {
    val x = Numero(1)
    val y = Numero(2)
    val z = x + y
    println("Soma: $z")
}
