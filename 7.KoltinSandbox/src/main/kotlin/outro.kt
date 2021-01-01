package br.com.alura.bytebank

import br.com.alura.bytebank.modelo.Endereco


fun main() {
//    expressions()
//    testeDelegate()
//    testLet()
//    ultimo()
}

fun expressions() {
    // try expression
    val result1 = try { 10 / 0 } catch(e: Throwable) { 0 } // Exception extends Throwable
    println(result1)

    // if as expression
    val result2 = if (true) 1 else 0
    println(result2)

    // when expression
    val result3 = when(1) { 1 -> "Um"; 2 -> "Dois"; else -> "Outro" }
    println(result3)
}

/*
 Não extenda diretamente de Throwable mas sim de Exception
 Error e Exception extendem de Throwable mas geralmente erros são lançados
 por quem trabalha desenvolvendo para jvm
*/

class SaldoInsuficiente(
    message: String = "O saldo é insuficiente"
) : Exception(message)

/*
 Ctrl + P = Mostrar argumentos possiveis de um método / construtor
 Ctrl + H = Mostrar hierarquia de classes subclasses e superclasses
*/

interface Authenticable {
    fun authenticate()
}

class User(val name: String) : Authenticable {
    override fun authenticate() {
        println("authenticate $name")
    }
}

// delegate automatico com by
class Account(val user: User): Authenticable by user

// delegate manual
class Account2(val user: User): Authenticable {
    override fun authenticate() = user.authenticate()
}

fun testeDelegate() {
    val user = User("Beltrano")
    val account = Account(user)
    account.authenticate()
}

fun ultimo() {
    var endereco: Endereco? = Endereco()

    println(endereco?.logradouro)
    endereco?.logradouro = "rua dos bobos"
    endereco.printString()
}


// Inline functions com generics é tipo um
// método inserido em Object.prototype no js
inline fun <T> T.printString() {
    println(this.toString())
}

// exemplo do let do koltin em js:
// Object.prototype.let = function(blockFunction) {
//     return blockFunction(this)
// }


fun testLet() {
//    Kotlin:
    listOf(1, 2, 3).map { it * 2 }.let { println(it) }
//    Javascript: [1, 2, 3].map(it => it * 2).let(console.log)
}