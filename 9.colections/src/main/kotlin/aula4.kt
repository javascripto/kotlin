fun main() {
    val livros = getBooks()

    val novoLivro = Livro(
        titulo = "Sagrana",
        autor = "João Guimarães Rosa",
        anoPublicacao = 1946,
    )

    livros.add(novoLivro)

    livros.imprimeComMarcadores()
    livros.sorted().imprimeComMarcadores() // ordenação implementada pela interface Comparable
    livros.sortedBy { it.titulo }.imprimeComMarcadores()

    livros
        .filter { it.autor.startsWith("Jo") }
        .sorted()
        .imprimeComMarcadores()
}

fun getBooks(): MutableList<Livro> {
    val livro1 = Livro(
        titulo = "Grande Sertão: Veredas",
        autor = "João Guimarães Rosa",
        anoPublicacao = 1956,
    )

    val livro2 = Livro(
        titulo = "Minha vida de menina",
        autor = "Helena Morley",
        anoPublicacao = 1942,
        editora = "Editora A",
    )

    val livro3 = Livro(
        titulo = "Memórias Póstumas de Brás Cubas",
        autor = "Machado de Assis",
        anoPublicacao = 1881,
    )

    val livro4 = Livro(
        titulo = "Iracema",
        autor = "José de Alencar",
        anoPublicacao = 1865,
        editora = "Editora B",
    )

    return arrayListOf(livro1, livro2, livro3, livro4)
}

data class Livro(
    val titulo: String,
    val autor: String,
    val anoPublicacao: Int,
    val editora: String? = null,
) : Comparable<Livro> { // Comparable permite ordenar lista
    override fun compareTo(other: Livro): Int {
        return this.anoPublicacao.compareTo(other.anoPublicacao)
    }
}

fun List<Livro>.imprimeComMarcadores() {
    val joinToString = this.joinToString(separator = "\n") {
        "- (${it.anoPublicacao}) ${it.titulo} de ${it.autor}"
    }
    println("### Lista de livros ###")
    println(joinToString)
}
