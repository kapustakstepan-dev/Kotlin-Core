package controller

import model.Director
import model.Person
import model.Student
import model.Teacher
import java.time.format.SignStyle
import kotlin.system.exitProcess

class School() {

    var people: ArrayList<Person> = arrayListOf()
    var director: Director? = null

    /*
    fun peopleExist(dni: String): Boolean {
        val peopleExist: Person? = people.find { it.dni.equals(dni, true) }
        val directorExist: Boolean = director != null
                && director?.dni.equals(dni, true)

        return peopleExist != null && directorExist
    }*/

    private fun existPeople(dni: String, mail: String?): Boolean{
        return people.any{it.dni.equals(dni, true) ||
                it.email.equals(mail, true)}
    }

    private fun personaExistDni(dni: String): Boolean {
        return people.any { it.dni.equals(dni, true)}
    }

    private fun findDirector(): Director? {
        return people.find { it is Director } as? Director
    }

    fun createDirector(nuevoDirector: Director) {
        val directorNow = findDirector()

        if (directorNow !=null && directorNow.dni.equals(nuevoDirector.dni, true)){
            println("Director esta registrado con el dni actual. ")
            return
        }

        if (existPeople(nuevoDirector.dni, nuevoDirector.email)){
            println("Ya existe una persona con el dni o correo de director. ")
            return
        }

        if (this.director != null) {
            println("Ya tienes un director, le quieres despedir")
            val despedir = readln()
            if (despedir.equals("si", true)) {
                println("director despedido")
                people.removeAll{it.dni.equals(directorNow?.dni, true)}
                people.add(nuevoDirector)
            } else {
                println("Nos quedamos con el director")
                return
            }
        } else {
            people.add(nuevoDirector)
            this.director = nuevoDirector
            println("Director contratado. ")
        }
    }

    fun addTeacher(teacher: Teacher) {
        if (existPeople(teacher.dni, teacher.email)) {
            println("Existe una persona con el dni o correo correspondinte. ")
        } else {
            println("Quieres contratar a este profesor? (si/no): ")
            val hireTeacher = readln()
            if (hireTeacher.equals("si", true)) {
                people.add(teacher)
                return
            }
            if (personaExistDni(teacher.dni)){
                println("Profe esta agregado correctamente. ")
            } else {
                println("Ha producido un error. ")
            }
        }

    }

    fun addStudent(student: Student) {
        if (existPeople(student.dni, student.email)){
            println("Este dni o correo ya se usa o puedes aniadir. ")
        } else {
            people.add(student)
            if (personaExistDni(student.dni)){
                println("Alumno agregado correctamente. ")
            } else {
                println("Ha producido un error. ")
            }
        }

    }

    fun listStudent() {
        people.forEach {
            if (it is Student) {
                it.mostrarDatos()
            }
        }
    }

    fun listTeacher() {
        people.forEach {
            if (it is Teacher) {
                it.mostrarDatos()
            }
        }
    }

    fun matricularAlumnos() {

    }

    fun gradeStudent(teacherDni: String, studentDni: String, grade: Double) {
        val teacher = people.find { it.dni.equals(teacherDni, true) }
        if (teacher == null) {
            println("No existe ningun profesor con ese dni. ")
            return
        }
        if (teacher !is Teacher) {
            println("La persona con ese dni no es un profesor. ")
            return
        }

        val student = people.find { it.dni.equals(studentDni, true) }
        if (student == null) {
            println("No existe ningun alumno con ese dni. ")
            return
        }
        if (student !is Student) {
            println("La persona con ese dni no es un alumno. ")
            return
        }

        if (grade < 1.0 || grade > 10.0) {
            println("La nota debe estar entre 1.0 y 10.0. ")
            return
        }

        student.grades.add(grade)
        println("Nota anadida correctamente. ")
    }

    fun calculateAverageGrade(studentDni: String) {
        val person = people.find { it.dni.equals(studentDni, true) }
        if (person == null) {
            println("No existe ningun alumno con ese dni. ")
            return
        }
        if (person !is Student) {
            println("La persona con ese dni no es un alumno. ")
            return
        }

        val average = if (person.grades.isEmpty()) 0.0 else person.grades.average()
        println("Nota media: $average")
    }

}