import kotlin.random.Random

fun main(){
    var elementos1: Array<Int?> = arrayOfNulls(5)
    //var elementos: Array<Int> = arrayOf(1,2,3,4,5,6)

    /*for (i in 0  until elementos1.size){
        println(elementos1[i])

    }

     */
    /*(0 until elementos1.size).forEach {
        println(elementos1[it])
    }

     */

    /*elementos1[0] = (10 ..20).random()

    for (i in elementos1){
        println(i)
    }

     */
    println("Introduzca size de array")
    val sizeArray = readln().toInt()
    println("Introduzca primer numero para el random")
    val n1 = readln().toInt()
    println("Introduzca segundo numero para el random")
    val n2 = readln().toInt()
    var lista: Array<Int?> = arrayOfNulls(sizeArray)
    funcion(sizeArray, n1, n2, lista)


}

fun funcion(sizeArray: Int, n1: Int, n2: Int, lista: Array<Int?>) {
    var suma: Int = 0

    ( 0 until lista.size).forEach {
        //it -> 0,1,2,3,4
        lista[it] = (n1..n2).random()
    }


    (0 until lista.size).forEach {
        //println(lista[it])
        suma+= lista[it] ?: 0
    }
    println("Es la suma $suma")

    val media: Int = lista.filterNotNull().average().toInt()
    println("Es el medio de la lista con el random $media")

    var numeroBuscar: Int = 0
    do {
        println("Que numero quieres buscar: ")
        numeroBuscar = readln().toInt()
    } while (numeroBuscar !in n1 ..n2)

    /*var contador = 0

    lista.forEach {
        if (it == numeroBuscar){
            contador++
        }
    }

     */

    println("Es el numero de elementos que coinciden con tu numero introducido ${lista.filter {numeroBuscar==it}.size}")

    println("${lista.find { it==numeroBuscar }?: "El numero no esta en la lista"}")


}