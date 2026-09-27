package model

class DJ(name: String, country: String, val hoursSetion: Int, val international: Boolean)
    : Artist(name, country) {



    override fun calculateCache(): Double {
        if (international == true){
            return ((hoursSetion *100)*2).toDouble()
        } else {
            return (hoursSetion *100).toDouble()
        }
    }

    override fun showData() {
        super.showData()
        println("hoursSetion = ${hoursSetion}")
        println("international = ${international}")

    }
}