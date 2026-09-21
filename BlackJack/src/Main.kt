import model.Cart
import model.Player

fun main() {

    var cart = Cart("1C")
    var palos = arrayOf("P","T","C","D")
    var baraja: ArrayList<Cart> = arrayListOf()

    palos.forEach { p ->
        (1..13).forEach { n->
            when(n){
                11 ->{
                    println("J$p")
                }
                12 ->{
                    println("Q$p")
                }
                13 ->{
                    println("K$p")
                }
                else -> {
                    println("$n$p")
                }

            }
        }
    }

    val jugadores : ArrayList<Player> = arrayListOf()




}