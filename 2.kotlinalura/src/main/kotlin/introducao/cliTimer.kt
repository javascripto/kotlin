package introducao

import java.util.Timer
import kotlin.concurrent.schedule
import kotlin.system.exitProcess

fun input(message: String): String {
    println(message)
    return readLine() ?: ""
}

fun main(args: Array<String>) {
    val nome = input("Qual seu nome?")
    println("Olá, $nome. Seja bem vindo!")

    Timer().schedule(2000) {
        println("Do something")
        exitProcess(0)
    }

    println("Executa antes do timer")
}
