package com.example.login.data

import com.example.login.model.Product
import com.example.login.model.User

class DataSet {
//TODO hacr hasta lunes conectados a los botones.
    //static
    companion object{
        // todos los elementos asociados a la clase y metodos
        val listUser: ArrayList<User> = arrayListOf()
        val listProducts: ArrayList<Product> = arrayListOf()


    fun initList(){
        listUser.add(User("admin", "admin", "admin@gmail.com","123", 0))
        listProducts.add(Product(1,"marmelada",  10.0, "marmelada",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT9Mdrv_u3wHh9DWrij8oLpdqsDETofEqt0Z565XOEDgQ&s=10"))
        listProducts.add(Product(2,"Honda CBR 1000Rr",  10000.0, "moto",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQaUfsj6kwy2KhcWchbqrqXZnQTJwhMJ79WjPPoY8Znvg&s=10"))



    }



        fun addUser(user: User): Boolean {
            //si no hay no usuario con ese correo ->aniades
            val exist = listUser.any{ user.mail == it.mail}
            if (!exist){
                listUser.add(user)
                return true
            }

            return false
        }

        fun getLogin(mail: String, pass: String):User? {
            return listUser.find{ mail == it.mail && pass == it.pass}
        }

    }

}