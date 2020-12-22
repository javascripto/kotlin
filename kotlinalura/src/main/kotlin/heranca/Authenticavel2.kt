package heranca

interface Authenticable {
    fun authenticate() = true
}

open class SuperClass {
    open fun authenticate() = false
}

class User : SuperClass(), Authenticable {
    override fun authenticate() = super<SuperClass>.authenticate() // Indicacão de qual implementaçao usar
}

fun main() {
    println(User().authenticate())
}