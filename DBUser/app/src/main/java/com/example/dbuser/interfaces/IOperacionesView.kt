package com.example.dbuser.interfaces

import com.example.dbuser.dataModel.UserDto

interface IOperacionesView {
    fun insertElement()
    fun showResultInsert(result : Int)
    fun selectUserName()
    fun showResulSelect(userDto: UserDto)

    fun selectUserId()
    fun showResultSelectId(userDto: UserDto)

}