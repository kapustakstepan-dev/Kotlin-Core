package model

class Teacher(name: String, surname: String, dni: String, email: String, val hours: Int, val salary: String)
    :Person(name, surname, dni, email) {

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("hours = ${hours}")
        println("salary = ${salary}")
    }
}