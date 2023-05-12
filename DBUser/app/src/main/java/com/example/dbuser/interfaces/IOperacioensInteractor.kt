package com.example.dbuser.interfaces

import com.example.dbuser.dataModel.UserDto

interface IOperacioensInteractor {

    fun insertUser(userDto: UserDto)
    fun selectUserName(name: String)
    fun selectUserId(id: Int)
    fun updateUser(userDto: UserDto)


}