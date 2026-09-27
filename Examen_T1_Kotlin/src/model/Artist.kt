package model

abstract class Artist(val name: String, val country: String) {
    var id: Long = 0L

    abstract fun calculateCache(): Double

    open fun showData(): Unit {
        println("name = ${name}")
        println("country = ${country}")
    }
    
}