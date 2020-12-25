package StaticProperties

import org.w3c.dom.html.HTMLInputElement

// Variaveis globais com acesso apenas dentro do arquivo
var total = 0
    private set

class TesteKotlin {
    // Kotlin não tem propriedades estáticas como no java.
    // É necessário um objeto companheiro para essa abordagem
    companion object counter {
        @JvmStatic
        var count = 0
            private set
    }

    init {
        count++
        total++
    }
}

fun mainn() {
    TesteKotlin()
    TesteKotlin()
    TesteKotlin()
    TesteJava()
    TesteJava()
    TesteJava()
    println("Acesso do java no kotlin: ${TesteJava.counter}")
    println("Acesso no koltin: ${TesteKotlin.count}")
    println("Acesso do kotlin no java: ${TesteKotlin.counter.count}")
    println("Variavel global do arquivo: ${total}")
}

class Input(val value: String)

interface MouseEvent {
    val target: Input
}

open class MouseAdapter {
    open fun mouseClicked(event: MouseEvent) {

    }
}

object window {
    lateinit var adapter: MouseAdapter

    fun addMouseListener(adapter: MouseAdapter) {
        this.adapter = adapter
    }

    fun click() {
        adapter.mouseClicked(object : MouseEvent {
            override val target = Input("teste")
        })
    }
}


fun main() {
    window.addMouseListener(object : MouseAdapter() {
        override fun mouseClicked(event: MouseEvent) {
            println(event.target.value)
        }
    })

    window.click()

}