package model

class Director(name: String, surname: String, dni: String, email: String, val workersNum: Int)
    :Person(name, surname, dni, email) {

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("workersNum = ${workersNum}")
    }
}