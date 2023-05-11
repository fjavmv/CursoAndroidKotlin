package com.example.dbuser.interfaces

import com.example.dbuser.dataModel.UserDto

interface IOperacionesPresenter {

    fun showResult(result : String)
    fun insertUser(userDto: UserDto): Long
    fun updateUser(userDto: UserDto): Int
    fun selectUsers(): ArrayList<UserDto>
    fun selectUserName(name: String): ArrayList<UserDto>
    fun deleteUser(name: String): Int

}