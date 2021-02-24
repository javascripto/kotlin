fun aula3() {
    123
        .myLet {
            println(it)
            it + 333
        }
        .myLet(::println)

    val getResult = somaHOF(3, 6) { resultado ->
        println(resultado)
    }
    println(getResult())
}

fun main() {
    aula3()
}

// High order function
fun somaHOF(a: Int, b: Int, resultado: (Int) -> Unit = {}): () -> Int {
    resultado(a + b)
    return { a + b }
}

inline fun <T, R> T.myLet(block: (T) -> R): R {
    return block(this)
}

//interface Object {
//    let<T, R>(blockFn: (object: T) => R): R;
//}
//
//Object.prototype.let = function<T, R>(block: (object: T) => R): R {
//    return block(this as T)
//};