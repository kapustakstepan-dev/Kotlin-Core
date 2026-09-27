package model

class Solista(name: String, country: String, val numDisk: Int, val instrument: String)
    :Artist(name,country) {


    override fun calculateCache(): Double {
        return (1000 + (numDisk*2)).toDouble()
    }

    override fun showData() {
        super.showData()

    }
}