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
    private var result = -1

    init {
        this.presenter = presenter
        //Pasamos el contexto a la clase OperacionesDaoImpl
        operacionesDao = OperationDaoImpl(context)
    }
    //Pasamos los datos que vienen de presentador
    override fun insertUser(userDto: UserDto){
        result = operacionesDao.insertUser(userDto).toInt()
        //Comunicamos el resultado de la inserción al presentador
        presenter.showResultInsert(result)
    }

    override fun updateUser(userDto: UserDto){
        TODO("Not yet implemented")
    }

    override fun selectUsers(){
        TODO("Not yet implemented")
    }

    override fun selectUserName(name: String){
        TODO("Not yet implemented")
    }

    override fun deleteUser(name: String){
        TODO("Not yet implemented")
    }
}