package com.example.dbuser.interfaces

import com.example.dbuser.dataModel.UserDto

interface IOperacioensInteractor {

    fun insertUser(userDto: UserDto)
    fun updateUser(userDto: UserDto)
    fun selectUsers()
    fun selectUserName(name: String)
    fun deleteUser(name: String)

}