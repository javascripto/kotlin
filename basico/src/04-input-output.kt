import java.util.Scanner

fun main(args: Array<String>) {

    print("Digite seu nome: ")

    var name: String = readLine()!! // Os !! são para obter valores não nulos

    print("Qual e a sua idade? ")

    var age = readLine()!!.toInt()

    println("Seu nome é $name e você tem $age anos.")
    println("Seu nome tem ${name.length} caracteres.")


    // Classe Scanner do Java

    val input = Scanner(System.`in`)

    print("Qual é o seu nome? ")

    name = input.next()

    println("Nome obtido pela classe Scanner: $name")

}
