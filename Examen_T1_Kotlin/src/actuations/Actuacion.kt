package actuations

import model.Artist

class Actuacion(val artist: Artist, val escenario: Escenario, val duration: Int) {
    val id: Long = 0

     fun showData(): Unit {
         println("id = ${id}")
        escenario.showData()
        artist.showData()
        println("duration = ${duration}")
    }

}