package actuations

class Escenario(val name: String, val capacidad: Int) {
    var id: Long = 0

    fun showData(): Unit {
        println("id = ${id}")
        println("name = ${name}")
        println("capacidad = ${capacidad}")
    }

}