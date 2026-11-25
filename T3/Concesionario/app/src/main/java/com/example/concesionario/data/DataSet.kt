package com.example.concesionario.data

import com.example.concesionario.R
import com.example.concesionario.model.Marca
import com.example.concesionario.model.Model

class DataSet {

    companion object{

        var listModel = arrayListOf<Model>(
            Model("Mondeo", 20000, 200, "Mondeo description", "Utilizable","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT1TurfHdbVmypX94NXSx4d2y_4SmH-UCP2OqLRyY-qog&s=10", "ford"),
            Model("Focus", 15000, 150, "Focus description", "Utilizable","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ07FQ77wPMgoaLnkk9ViW_7odVAt-HQrEx50EHX0ZIHg&s=10", "ford"),
            Model("Fiesta", 10000, 100, "Fiesta description", "Urbado","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRJA06Irxwo0bbNK9s_oseRDQYTmSfA41F8lXqqI-zVPg&s=10", "ford"),

            Model("A3", 35000, 200, "A3 description", "Utilizable","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT8pDfO0mrcHsYO9z4T7VGBKsp8uwNBc5fbJs6Pa6cXYw&s=10", "audi"),
            Model("A5", 40000, 300, "A5 description", "Familiar","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSHENRZwZ8ezQQHT-Ys-wP2RwfGGpr9tki8KGGmot20oQ&s=10", "audi"),
            Model("A7", 75000, 660, "A7 description", "Sport car","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRsm31SGQV8V_YUx3eTdSOjdo0uYfPQ_byxeRQMe8C_5Q&s=10", "audi"),

            Model("W222", 180000, 800, "W222 description", "Premium","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSqm-nLzEStfn-fK0FFJWs38_HOteJ4czuO3C_38TYzuw&s=10", "mercedes"),
            Model("W213", 67000, 600, "W213 description", "Sport car","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQvdfjfYweNjwX5Xdxx4eYOmnBzMky9DyiDt2paWk1lOQ&s=10", "mercedes"),
            Model("W123", 80000, 150, "W123 description", "Legendary car","https://i.pinimg.com/736x/cf/08/50/cf0850b750abe5e38b8f7143e61b9062.jpg", "mercedes"),

            )

        var listaMarca = arrayListOf<Marca>(
            Marca(
                R.drawable.ford, "Ford", listModel.filter { it.marca == "ford" }
            ),
            Marca(
                R.drawable.audi, "Audi", listModel.filter { it.marca == "audi" }
            ),
            Marca(
                R.drawable.mercedes, "Mercedes", listModel.filter { it.marca == "mercedes" }
            ),

        )











    }
}