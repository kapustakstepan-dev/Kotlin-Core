import actuations.Actuacion
import actuations.Escenario
import controller.Controller
import model.Artist
import model.DJ
import model.GrupoMusical
import model.Solista

fun main() {

    val controller = Controller()
    var option : Int = 0

    do {

        println("\n\tMenu")
        println("1. Agregar artista: ")
        println("2. Registrar escenario ")
        println("3. Programar actuacion ")
        println("4. Buscar artista por pais ")
        println("5. Obtener artista mas caro  ")
        println("6. Obtener costes totales ")
        println("7. Mostrar actuaciones ")
        println("8. Salir... ")
        println("Elige una opcion: ")


        option = readln().toInt()
        when (option){
            1->{
                println("\nName: ")
                val name = readln()
                println("Pais: ")
                val country = readln()

                println("1. DJ, 2. Grupo Musical, 3. Solista")
                var op = readln().toInt()
                val artist = when (op){
                     1->{
                        println("\nHoras Sesion: ")
                        val hoursSetion = readln().toInt()
                        println("Internacional: (si/no)")
                        var international = readln().toBoolean()
                        if (international.equals("si")){
                            international = true
                        } else {
                            international = false
                        }

                        DJ(name, country, hoursSetion, international)
                    }
                    2->{
                        println("Componentes: ")
                        val components = readln().toInt()
                        println("Genero: ")
                        val genero = readln()

                        GrupoMusical(name,country,components,genero)
                    }
                    3->{
                        println("Numero discos: ")
                        val numDisk = readln().toInt()
                        println("Instrumento: ")
                        val instrument = readln()

                        Solista(name,country,numDisk,instrument)
                    }
                    else -> {
                        println("Opcion no valida")}
                }

                controller.addArtist(artist as Artist)
            }
            2->{
                println("Name: ")
                val name = readln()
                println("Capacidad: ")
                val capacidad = readln().toInt()
                controller.addEscenario(Escenario(name, capacidad))
            }
            3->{
                //no funciona
                //controller.programActiation()
            }
            4->{
                println("Pais: ")
                val country = readln()
                controller.searchArtistByCountry(country)
            }
            5->{controller.takeArtistMoreCost()}
            6->{controller.allCost()}
            7->{controller.showActuations()}
            8->{println("Saliendo...")}
            else -> println("Opcion no valida")
        }

    } while (option!=8)


}