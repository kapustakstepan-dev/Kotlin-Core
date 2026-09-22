import controller.School
import model.Director
import model.Document
import model.Student
import model.Teacher
import kotlin.random.Random


fun main() {

    val school = School()
    var opcion: Int

    do {
        println("\n1. Crear documento: ")
        println("2. Contratar Director: ")
        println("3. Contratar Profesor: ")
        println("4. Matricular Alumno: ")
        println("5. Ver todos los alumnos: ")
        println("6. Ver todos los profes: ")
        println("7. Calificar alumno: ")
        println("8. Calcular la nota media de alumno: ")
        println("9. Comprobar los errores: ")
        println("0. Salir...")
        println("\n\tElige una opcion: ")
        opcion = readln().toInt()

        when (opcion){
            1 ->{
                println("Autor: ")
                val autor: String = readln()
                println("Tema: ")
                val theme: String = readln()
                println("Extencion: ")
                val extencion: Int = readln().toInt()
                println("Formato: ")
                val format: String = readln()

                val document = Document(autor, theme, extencion, format)
                if (document!= null){
                    println("Documento esta creado.")
                } else {
                    println("Se ha producido un error con el documeto")
                }

            }
            2 ->{
                println("Nombre: ")
                val name: String = readln()
                println("Apellido: ")
                val surname: String = readln()
                println("DNI: ")
                val dni: String = readln()
                println("Email: ")
                val email: String = readln()
                println("Numero de trabajadores que tiene: ")
                val workersNum: Int = readln().toInt()

                school.createDirector(Director(name, surname, dni, email, workersNum))
            }
            3 ->{
                println("Nombre: ")
                val name: String = readln()
                println("Apellido: ")
                val surname: String = readln()
                println("DNI: ")
                val dni: String = readln()
                println("Email: ")
                val email: String = readln()
                println("Horas de semanales: ")
                val hours: Int = readln().toInt()
                println("Nomina: ")
                val salary: String = readln()

                school.addTeacher(Teacher(name, surname, dni, email, hours, salary))

            }
            4 ->{
                println("Nombre: ")
                val name: String = readln()
                println("Apellido: ")
                val surname: String = readln()
                println("DNI: ")
                val dni: String = readln()
                println("Email: ")
                val email: String = readln()
                println("Codigo de alumno: ")
                val studentCode: Int = readln().toInt()
                val nmat: Int = Random.nextInt(100000, 999999)

                school.addStudent(Student(name, surname, dni, email, studentCode, nmat))

            }
            5 ->{school.listStudent()}
            6 ->{school.listTeacher()}
            7 ->{}
            8 ->{}
            9 ->{}
            0 ->{println("Saliendo...")}


        }

    } while (opcion !=0)
}