
fun main() {
    showCopy()
    showDestructuring()
}

data class Person(
    var name: String,
    val age: Int = 0
)

fun showCopy() {
    val person1 = Person("fulano")
    val person2 = person1
    val person3 = person2.copy()

    person1.name = "Beltrano"

    println("$person1\n$person2\n$person3")

    println(person1 == person2)
    println(person2 == person3)
}

// destructuring só funciona em data classes ou classes
// que implementem componentN methods de acordo com a ordem
// de declaração de variaveis no construtor.
// destructuring só funciona se as variveis forem extraídas
// na ordem correta
fun showDestructuring() {
    class MyDestructurableClass(
        val prop1: String = "",
        val prop2: String = "",
    ) {
        operator fun component1(): String = prop1
        operator fun component2(): String = prop2
    }

    // destructuring com objetos
    val ( name, age ) = Person("fulano")
    println("name: $name, age: $age")

    // destructuring com listas
    val (first, second, third) = listOf(1, 2, 3)
    println("first: $first, second: $second, third: $third")


    // componentN methods
    val (prop1) = MyDestructurableClass("asd")
    println(prop1)

    val person = Person("Fulano", 20)
    val personName = person.component1()
    val personAge = person.component2()
    println("Name: $personName, age: $personAge")
}
