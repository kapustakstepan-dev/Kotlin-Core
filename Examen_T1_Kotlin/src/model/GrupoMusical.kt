package model

class GrupoMusical(name: String, country: String, val components: Int, val genero: String)
    :Artist(name, country) {


    override fun calculateCache(): Double {

        return ((1500 + components) *4).toDouble()
    }

    override fun showData() {
        super.showData()
        println("components = ${components}")
        println("genero = ${genero}")
    }
}