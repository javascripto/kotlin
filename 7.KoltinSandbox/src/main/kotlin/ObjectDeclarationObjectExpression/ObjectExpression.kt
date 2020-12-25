package ObjectDeclarationObjectExpression


fun main() {
    testSingleton()
    testCompanionObject()
}

interface WithDescription {
    val description: String
}

// Object declaration
object Singleton {
    private lateinit var instance: WithDescription

    fun getInstance(): WithDescription {
        if (!::instance.isInitialized) {
            // Object expression
            instance = object : WithDescription {
                override val description = "this is an object expression inside an object declaration"
                // Object expression x Object declaration
                // Object expressions são anônimos

            }
        }
        return instance
    }
}

// Companion objects permitem que classes acessem propriedades do objeto
// de classe como se fosse uma propriedade da propria classe ou instancia.
// Apenas um companion object é permitido por classe e ele não precisa ter um nome.
// Caso seja um companion object anonimo, o acesso pelo java se dá pelo nome Companion
class MyClass {
    var instanceCount = 0

    companion object Counter {
        var count = 0
    }

    init {
        count++
        instanceCount++
    }

    override fun toString(): String {
        return "instanceCount: $instanceCount"
    }
}

fun testSingleton() {
    println(Singleton.getInstance().description)
}

fun testCompanionObject() {
    val instance1 = MyClass()
    val instance2 = MyClass()
    val instance3 = MyClass()
    println(instance1)
    println(instance2)
    println(instance3)
    println("totalCount: ${MyClass.count}")
    println("Acesso no Java: ${MyClass.Counter.count}")
}