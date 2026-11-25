package com.example.repasoandroid.dataset

import com.example.repasoandroid.model.User

class DataSet {

    companion object{
        var userList: ArrayList<User> = arrayListOf()

        fun initList() {
            userList.add(User("adri","ads","123",1))
            userList.add(User("ewq","asd","123",0))
            userList.add(User("qwe","sa","123",1))
            userList.add(User("asd","dsadsa","123",0))


        }
        fun addUser(user: User): Boolean {
            val exists = userList.any{user.mail == it.mail}

            if (!exists){
                userList.add(user)
                return true
            }
            return false
        }

        fun getLogin(mail: String, pass: String): User? {
            return userList.find { mail == it.mail && pass == it.pass }
        }
    }
}