package com.example.dbuser.interfaces

import com.example.dbuser.dataModel.UserDto

interface IOperacionesPresenter {

    fun showResultInsert(result: Int)
    fun insertUser(userDto: UserDto)
    fun selectUserName(name:String)
    fun showResulSelect(userDto: UserDto)

    fun selectUserId(id: Int)
    fun showResultSelectId(userDto: UserDto)


}