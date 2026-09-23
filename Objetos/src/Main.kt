import controller.School
import model.Director
import model.Document
import model.Person
import model.Student
import model.Teacher
import kotlin.math.exp
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
            7 ->{
                println("DNI del profesor: ")
                val teacherDni: String = readln()
                println("DNI del alumno: ")
                val studentDni: String = readln()
                println("Nota (1.0 - 10.0): ")
                val grade: Double = readln().toDouble()

                school.gradeStudent(teacherDni, studentDni, grade)
            }
            8 ->{
                println("DNI del alumno: ")
                val studentDni: String = readln()

                school.calculateAverageGrade(studentDni)
            }
            9 ->{
                val testSchool = School()
                val testDirector = Director("Test", "Director", "00000000A", "director@test.com", 1)
                val testTeacher = Teacher("Test", "Teacher", "11111111B", "teacher@test.com", 20, "2000")
                val testStudent = Student("Test", "Student", "22222222C", "student@test.com", 1, 100000)
                val testStudentSinNotas = Student("Test", "Student2", "33333333D", "student2@test.com", 2, 100001)
                testSchool.director = testDirector
                testSchool.people.add(testDirector)
                testSchool.people.add(testTeacher)
                testSchool.people.add(testStudent)
                testSchool.people.add(testStudentSinNotas)

                println("\n-- Profesor con dni inexistente --")
                testSchool.gradeStudent("99999999Z", testStudent.dni, 5.0)

                println("\n-- Dni de profesor que en realidad es de un alumno --")
                testSchool.gradeStudent(testStudent.dni, testStudent.dni, 5.0)

                println("\n-- Alumno con dni inexistente --")
                testSchool.gradeStudent(testTeacher.dni, "88888888Y", 5.0)

                println("\n-- Dni de alumno que en realidad es de un profesor --")
                testSchool.gradeStudent(testTeacher.dni, testTeacher.dni, 5.0)

                println("\n-- Nota fuera de rango (1.0 - 10.0) --")
                testSchool.gradeStudent(testTeacher.dni, testStudent.dni, 15.0)

                println("\n-- Caso correcto: se anade una nota --")
                testSchool.gradeStudent(testTeacher.dni, testStudent.dni, 8.0)

                println("\n-- Media con dni inexistente --")
                testSchool.calculateAverageGrade("77777777X")

                println("\n-- Media con dni que no es de un alumno --")
                testSchool.calculateAverageGrade(testTeacher.dni)

                println("\n-- Media de un alumno sin notas (debe ser 0.0) --")
                testSchool.calculateAverageGrade(testStudentSinNotas.dni)

                println("\n-- Media de un alumno con notas --")
                testSchool.calculateAverageGrade(testStudent.dni)
            }
            0 ->{println("Saliendo...")}


        }

    } while (opcion !=0)
}