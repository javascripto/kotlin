package ToStringHashCodeEquals

// É possivel gerar um toString com as propriedades usando (Alt + Insert)
// Com (Alt + Enter) numa string, é possível converter para Raw String que usa 3 aspas
// data classes ganham a implementação do equals de presente para comparar valores de objetos ao invés da referencia
// equals e hashcode estão bem relacionados, se voc6e altera o equals, o hashcode de dois objetos semelhantes deveria ser o mesmo

fun main() {
    val person1 = Person("Fulano")
    val person2 = Person("Beltrano")

    // Override de método de instancia
    val person3: Person = object : Person("Cicrano") {
        override fun toString() = """{ "name": "$name"}"""
    }

//    println(person1)
//    println(person2)
//    println(person3)

    val endereco = Endereco(
        logradouro = "Rua dos Bobos",
        numero = 0,
        bairro = "Centro",
        cidade = "Acapulco",
        estado = "BA",
        cep = "12345678",
    )

    val endereco1 = Endereco(logradouro = "teste")
    val endereco2 = Endereco(logradouro = "teste")

//    println(endereco1.equals(endereco2))

//   31 * (31 * (31 * (31 * 89) + 117) + 114) + 105
// 2767475

    println("Y".hashCode())
    println("u".hashCode())
    println("r".hashCode())
    println("i".hashCode())
    println("Yu".hashCode())
    println("Yur".hashCode())
    println("Yuri".hashCode())


//    println(endereco2.hashCode())
}

open class Person(val name: String) {
    override fun toString(): String {
        return "Person(name='$name')"
    }

}

fun getClassName(targetObject: Any): String {
    return targetObject.javaClass.toString().replace(oldValue = "class ", newValue = "")
}

fun defaultToString(targetObject: Any): String {
    val className = getClassName(targetObject)
    val hexHashCode = Integer.toHexString(targetObject.hashCode())
    return "$className@$hexHashCode"
}


data class Endereco(
    val logradouro: String = "",
    val numero: Int = 0,
    val bairro: String = "",
    val cidade: String = "",
    val estado: String = "",
    val cep: String = "",
    val complemento: String = "",
) {
    override fun toString(): String {
        return """
            Endereco(
                logradouro='$logradouro',
                numero=$numero,
                bairro='$bairro',
                cidade='$cidade',
                estado='$estado',
                cep='$cep',
                complemento='$complemento'
            )
        """.trimIndent()
    }
}

class MyPerson(
    val name: String,
) {
    override fun toString() = "Name: $name"

    override fun equals(other: Any?): Boolean {
        if (other != null && other is Person)
            return other.name == name
        return false
    }

    override fun hashCode() = name.hashCode()
}


class Teste1(val name: String, val age: Int) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Teste1

        if (name != other.name) return false
        if (age != other.age) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + age
        return result
    }
}