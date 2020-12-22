package introducao

// Ctrl + Shift + F10 = Compilar e executar arquivo
// Shift + F10 = Compilar e executar ultimo arquivo escolhido
// Alt + Enter = Abrir pop-up de sugestôes do intellij
// Ctrl + ALt + L = Formatar codigo
// Ctrl + Shift + A = Janela de ações
// Shift + F6 = Refatorar
// Ctrl + Shift + + ou - = Collapse / Expand
// ALt + J = Selecionar outra ocorrencia

//fun main(args: Array<String>) {
//    for (string in args)
//        println(string)
//}

// https://khan.github.io/kotlin-for-python-developers/
// https://kotlinlang.org/docs/reference/classes.html#constructors

fun primeira() {
    println("Olá mundo")

    val text = "const"
    var text2 = "let"

    println("Template string: $text $text2")
}

fun testaCondicoesWhen(saldo: Double) {
    when {
        saldo < 0.0 -> println("Conta negativa")
        saldo == 0.0 -> println("Conta zerada")
        else -> println("Conta positiva")
    }
}

fun forLoops() {
    for (i in 1..3) println(i); println()
    for (i in 3 downTo 1) println(i); println()
    for (i in 0..6 step 2) println(i)
}

fun `function com crase e acentuação`() {
    println("Estranho né?")
}

fun classes() {

    class Conta(val titular: String, val numero: Int, val saldo: Double) {
        init {
            println("Inicializou conta do titular: ${titular}")
        }

        override fun toString(): String {
            return """
            Titular: $titular
            Numero: $numero
            Saldo: $saldo
        """.trimIndent()
        }
    }

    class Person {
        val fullname: String
        private val name: String

        init {
            println("bloco de inicialização init")
        }

        constructor(name: String, lastName: String) {
            this.name = name
            fullname = "$name $lastName"
            println("construtor secundário")
        }
    }

    class Person2(name: String) {
        val name: String

        init {
            this.name = name
        }
    }

    val conta1 = Conta("Fulano", 1, 1000.0)
    val conta2 = Conta(titular="Fulano", numero=1, saldo=1000.0) // Named arguments


    println(conta1)

    val obj = object {
        val nome = "Yuri"
    }

    data class Teste(var teste: Int)
    val teste = Teste(1)
    teste.teste = 2
    println(obj.nome)
    println(teste.teste)
}


fun classes2() {

    class Conta0(val titular: String, val conta: Int, var saldo: Double)

    class Conta1(val titular: String, val conta: Int, var saldo: Double) {
        init {
            println("Conta inicializada para o cliente $titular")
        }
        fun depositar(valor: Double): Conta1 {
            saldo += valor
            return this
        }
        fun sacar(valor: Double): Double {
            if (valor <= saldo) {
                saldo -= valor
                return valor
            }
            return 0.0
        }
        fun transferir(valor: Double, contaDestino: Conta1): Boolean {
            if (valor <= saldo) {
                contaDestino.depositar(this.sacar((valor)))
                return true
            }
            return false
        }
    }

    class Conta2 {
        val titular: String

        var conta: Int
            private set
            get() = field // field é como se fosse o this da propriedade

        var saldo: Double = 0.0
            private set(value) {
                field = value
            }

        constructor(titular: String, conta: Int) { // construtor secundario
            this.titular = titular
            this.conta = conta
        }

        fun sacar(valor: Double): Double {
            if (podeSacar(valor)) {
                saldo -= valor
                return valor
            }
            return 0.0
        }

        fun depositar(valor: Double): Conta2 {
            saldo += valor
            return this
        }

        fun transferir(valor: Double, conta2Destino: Conta2): Boolean {
            if (podeSacar(valor)) {
                conta2Destino.depositar(sacar(valor))
                return true
            }
            return false
        }

        private fun podeSacar(valor: Double): Boolean = saldo >= valor

        override fun toString() = "Conta: $conta Saldo: $$saldo"
    }

    val conta = Conta2("Yuri", 3197)
    val conta2 = Conta2(titular = "Fulano", conta = 123) // labels ou argumentos nomeados

    conta
            .depositar(300.0)
            .depositar(300.0)

    if (conta.sacar(30.0) > 0.0)
        println("Saque realizado")
    else
        println("Saldo insuficiente para saque")

    if (conta.transferir(80.0, conta2Destino=conta2))
        println("Transferencia realizada")
    else
        println("Saldo insuficiente para transferencia")


    println(conta)
    println(conta2)
}


interface WithDocument {
    fun getDocument(): String
}

fun herança() {
    open class Person(open val name: String) {
        override fun toString(): String {
            return "{ name: $name }"
        }
    }

    class PersonDocument(
            override val name: String,
            val cpf: String
    ) : Person(name), WithDocument {
        override fun getDocument() = cpf
        override fun toString(): String {
            return "{ name: $name, cpf: $cpf }"
        }
    }

    val p = PersonDocument("John", "01234567890")
    println(p)
}

fun introducao() {
    primeira()
    testaCondicoesWhen(10.0)
    forLoops()
    `function com crase e acentuação`()
    classes()
    classes2()
    herança()
}

