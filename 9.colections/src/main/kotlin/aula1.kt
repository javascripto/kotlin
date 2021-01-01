fun main() {
    val idadesJava: Array<Int> = Array<Int>(4) { 1 }
    val idadesArray: Array<Int> = arrayOf(10, 21, 27, 17)
    val idadesIntArray = intArrayOf(idadesArray[0], idadesArray[1], idadesArray[2], idadesArray[3])
    val idades = IntArray(4)

    idades[0] = idadesIntArray[0]
    idades[1] = idadesIntArray[1]
    idades[2] = idadesIntArray[2]
    idades[3] = idadesIntArray[3]

    var maiorIdade: Int

    // for in
    maiorIdade = idades[0]
    for (idade in idades)
        maiorIdade = Math.max(maiorIdade, idade)

    // for in com indices
    maiorIdade = idades[0]
    for (index in idades.indices)
        maiorIdade = Math.max(maiorIdade, idades[index])

    // forEach
    maiorIdade = idades[0]
    idades.forEach { maiorIdade = Math.max(it, maiorIdade) }

    // reduce
    maiorIdade = idades.reduce { maior, idade -> Math.max(maior, idade) }

    println("Maior idade: $maiorIdade")


    println("Maior idade: ${idades.max()!!}")
    println("Menor idade: ${idades.min()!!}")


    idades.forEach { println(it) }
    idades.forEachIndexed { index, idade -> println("Idade${index + 1}: $idade") }


    val idadesDobradas = idades.map { idade -> idade * 2 }
    val idadeTriplicada = idades.map { it * 3 }
    val idadesIndexes: List<Int> = idades.mapIndexed { index, it -> index }

    println(idades.contentToString())
}