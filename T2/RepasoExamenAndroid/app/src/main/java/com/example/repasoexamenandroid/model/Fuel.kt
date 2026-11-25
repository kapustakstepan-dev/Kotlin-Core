package com.example.repasoexamenandroid.model

import com.example.repasoexamenandroid.R // hay que cambiar por ese si o si para que cambien

class Fuel(
    val id: Long,
    val nameFuel: String,
    val icon: Int
) {
    companion object{
        const val DIESEL = 0L
        const val GASOLINA = 1L
        const val HIBRIDO = 2L
        const val ELECTRICO = 3L

        fun getFuelList(): List<Fuel> = listOf(
            Fuel(DIESEL, "DIESEL", R.drawable.diesel),
            Fuel(GASOLINA, "GASOLINA", R.drawable.gasolina),
            Fuel(HIBRIDO, "HIBRIDO", R.drawable.hibrido),
            Fuel(ELECTRICO, "ELECTRICO", R.drawable.electrico)
        )
    }
}