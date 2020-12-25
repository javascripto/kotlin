package ObjectImplementsInterface

// objects expessions podem impleentar interfaces e herdar de classes

class Input(val value: String)

interface MouseEvent {
    val target: Input
}

abstract class MouseAdapter {
    abstract fun mouseClicked(event: MouseEvent)
}

object window {
    private lateinit var adapter: MouseAdapter

    fun addMouseListener(adapter: MouseAdapter) {
        this.adapter = adapter
    }

    fun click() {
        if (!::adapter.isInitialized) return

        adapter.mouseClicked(object : MouseEvent {
            override val target = Input("test value")
        })
    }
}


object window2 {
    private val adapters: ArrayList<MouseAdapter> = arrayListOf()

    fun addMouseListener(adapter: MouseAdapter) {
        this.adapters.add(adapter)
    }

    fun click() {
        if (adapters.size == 0) return

        adapters.forEach {
            it.mouseClicked(object : MouseEvent {
                override val target = Input("test value")
            })
        }
    }
}

fun main() {
    window2.addMouseListener(object : MouseAdapter() {
        override fun mouseClicked(event: MouseEvent) {
            println(event.target.value)
        }
    })

    window2.click()

    val teste = object {
        val name = "name"
    }
}
