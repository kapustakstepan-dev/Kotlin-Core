import kotlin.math.sign

/* todo
    Realizar una aplicación que
    decida que alumno de la clase saldrá a mostrar la solución de los ejercicios
    1. Un menu donde tenga las siguientes opciones
    1. Crear clase -> índica cuantos alumnos hay en la clase
    2. Matricular alumnos -> pedirá el nombre de todos los alumnos (puede haber nombres peptides)
    3. Mostrar alumnos clase -> mostrará los nombres de todos los alumnos disponibles (los nulos no los mostrará)
    4. Sacar alumno a pizarra -> mostrará el nombre del alumno que saldrá a la pizarra. Solo funcionará si todos
    los alumnos están matriculados. En caso de no estar llena, mostrará un aviso
*/

    var clase: Array<String?>? = null
fun main() {
    var opcion: Int

    do {
        println("\n===Menu de la clase===")
        println("1. Crear clase")
        println("2. Matricular alumnos")
        println("3. Mostrar alumnos de la clase")
        println("4. Sacar alumno a pizarra")
        println("5. Salir...")
        println("Que eliges?")
        opcion = readln().toIntOrNull() ?: 0;

        when (opcion) {
            1 ->{crearClase()}
            2 ->{matricularAlumnos()}
            3 ->{mostrarClase()}
            4 ->{sacarAPizarra()}
            5 ->{println("Saliendo...")}
            else -> println("Opción no válida. Inténtalo de nuevo.")
        }
    } while (opcion != 5)

}

fun crearClase() {
    println("Indica cuantos alumnos hay en la clase: ")
    var cantidadAlumnos: Int = readln().toIntOrNull() ?: 0;

    if (cantidadAlumnos > 0){
        clase = arrayOfNulls(cantidadAlumnos)
        println("Has creado la clase con $cantidadAlumnos")
    } else {
        println("La canridad de alumnos en la clase es negativa!")
    }
}

fun matricularAlumnos(){
    val cal = clase
    if (cal == null){
        println("No has creado la clase")
        return
    }

    println("Vamos a matricular alumnos")
    for (i in cal.indices){
        println("Introduzca nombre del alumno ${i + 1}")
        cal[i] = readln()
    }
    println("Todos los alumnos de la clase han sido matriculados")

}

fun mostrarClase(){
    val cal = clase
    if (cal == null){
        println("No has creado la clase")
        return
    }

    println("\n\tAlumnos matriculados de la clase")
    for (i in cal.indices){
        if (cal[i] != null){
            println("-> ${cal[i]}")
        }
    }

}
fun sacarAPizarra(){
    val cal = clase
    if (cal == null){
        println("No has creado la clase")
        return
    }

    var estaLleno : Boolean = false
    for (i in cal.indices){
        if (cal[i] == null){
            estaLleno =true
            break
        }
    }
    if (estaLleno){
        println("No has matriculado a todos los alumnos de la clase")
    } else {
        var sacarAlumno : Int = (0 until cal.size).random()
        println("Alumno que sala a la pizarra es ${cal[sacarAlumno]}")
    }

}