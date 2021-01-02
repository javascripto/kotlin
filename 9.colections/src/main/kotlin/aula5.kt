fun main() {
    printWithoutNulls()
    groupByField()
    prateleira()
}

fun printWithoutNulls() {
    val livros: MutableList<Livro?> = mutableListOf(null, null, null)
    getBooks().forEach { livros.add(it) }
    livros.imprimeComMarcadores()
}

fun groupByField() {
    getBooks()
        .groupBy { it.editora ?: "Desconhecida" }
        .forEach { (editora, livros) ->
            println("\nEditora: $editora")
            livros.imprimeComMarcadores()
        }
}

fun prateleira() {
    val prateleira = Prateleira(
        genero = "Literatura",
        livros = getBooks(),
    )
    prateleira.organizarPorAnoPublicacao().imprimeComMarcadores()
    prateleira.organizarPorAutor().imprimeComMarcadores()
}

data class Prateleira(
    val genero: String,
    val livros: List<Livro>,
) {
    fun organizarPorAutor() = livros.sortedBy { it.autor }
    fun organizarPorAnoPublicacao() = livros.sortedBy { it.anoPublicacao }
}

// MutableList tem o método sortBy
// List tem o método sertedBy
// o sortbBy tem efeitos colaterais sobre a lista e não retorna uma nova lista
