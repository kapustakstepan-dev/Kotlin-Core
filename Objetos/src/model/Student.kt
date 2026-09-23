package model

class Student(name: String, surname: String, dni: String,
              email: String, val studentCode: Int, val nmat: Int)
    :Person(name, surname, dni, email) {

    val grades: MutableList<Double> = mutableListOf()

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("studentCode = ${studentCode}")
        println("nmat = ${nmat}")
    }
}