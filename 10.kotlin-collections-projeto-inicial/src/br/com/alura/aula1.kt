package br.com.alura


fun main() {
    val banco = BancoDeNomes()

    listOf("Maria", "João", "Alex", "Beto", "Claudia")
        .forEach { banco.addNome(it) }

    val collection: Collection<String> = banco.nomes

    println(collection)

}

class BancoDeNomes {
    companion object {
        private val dados: MutableList<String> = mutableListOf<String>()
    }

    val nomes: List<String> get() = dados.toList()

    fun addNome(nome: String) = dados.add(nome)
}


fun getList(): List<Int> {
    val arrayList = arrayListOf(1, 5, 2)
    java.util.Collections.sort(arrayList, object : Comparator<Int> {
        override fun compare(x: Int, y: Int) = y - x
    })
    return arrayList
}