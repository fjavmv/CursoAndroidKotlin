package com.example.dbuser.model

import android.content.Context
import com.example.dbuser.dataModel.UserDto
import com.example.dbuser.db.dbHelper.dao.OperationDaoImpl
import com.example.dbuser.interfaces.IOperacioensInteractor
import com.example.dbuser.interfaces.IOperacionesPresenter
import com.example.dbuser.interfaces.IOperationDao

class InteractorOperacionesImpl (presenter: IOperacionesPresenter, context: Context): IOperacioensInteractor {

    private val presenter: IOperacionesPresenter
    private val operacionesDao: IOperationDao

    init {
        this.presenter = presenter
        operacionesDao = OperationDaoImpl(context)
    }


    override fun insertUser(userDto: UserDto): Long {
        return operacionesDao.insertUser(userDto)
    }

    override fun updateUser(userDto: UserDto): Int {
        TODO("Not yet implemented")
    }

    override fun selectUsers(): ArrayList<UserDto> {
        TODO("Not yet implemented")
    }

    override fun selectUserName(name: String): ArrayList<UserDto> {
        TODO("Not yet implemented")
    }

    override fun deleteUser(name: String): Int {
        TODO("Not yet implemented")
    }
}