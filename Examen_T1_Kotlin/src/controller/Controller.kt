package controller

import actuations.Actuacion
import actuations.Escenario
import model.Artist

class Controller {

    var id: Long = 0
    val listArtist: ArrayList<Artist> = arrayListOf()
    val listActuacion: ArrayList<Actuacion> = arrayListOf()
    val listEscenario: ArrayList<Escenario> = arrayListOf()

    fun addArtist(artist: Artist): Boolean {
       if (listArtist.any { it.id == artist.id }){
           println("Ya existe artista con ese id")
           return false
       }
        id++
        artist.id = id
        return listArtist.add(artist)
    }

    fun addEscenario(escenario: Escenario): Boolean {
        if (listArtist.any { it.id == escenario.id }){
            println("Ya existe artista con ese id")
            return false
        }
        id++
        escenario.id = id
        return listEscenario.add(escenario)
    }


    //no lo se
    fun programActiation(idArtist: Int, idEscenario: Int): Unit {
        
    }

    fun searchArtistByCountry(country: String) {
        val searchs = listArtist.filter { it.country.equals(country, true) }

        if (searchs.isEmpty()) {
            println("No hay ningun artista de esta pais")
        } else {
            println("Artistas de pais: ${country}")
            searchs.forEach { it.showData() }
        }
    }

    fun takeArtistMoreCost(): Artist? {
        val moreCost = listArtist.maxByOrNull { it.calculateCache() }
        if (moreCost != null){
            println("Artista mas costoso es")
            moreCost.showData()
        } else {
            println("No hay registrados los artistas para saber quien es mas costoso ")
        }

        return moreCost
    }

    fun allCost(): Double {
        val allCosts = listArtist.sumOf { it.calculateCache() }

        println("Costes totales son: ")
        return allCosts
    }

    fun showActuations(): Unit {
        if (listActuacion.isEmpty()){
            println("No hay los actuaciones ")
        } else {
            listActuacion.forEach { it.showData()}
        }
    }

}