package model

class Cart(representation: String) {
    var valor:Int? = null
    var palo: String? = null

    init {
        when (representation.substring(0,representation.length-1)){
            "J","Q","K" -> {
                valor = 10
            }
            else -> {
                valor = representation.substring(0,representation.length-1).toInt()
            }
        }
    }

}