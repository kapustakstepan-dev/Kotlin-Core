package com.example.login.data

import com.example.login.model.User

class DataSet {
//TODO hacr hasta lunes conectados a los botones.
    //static
    companion object{
        // todos los elementos asociados a la clase y metodos
        val listUser: ArrayList<User> = arrayListOf()

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