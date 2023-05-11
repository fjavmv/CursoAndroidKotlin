package com.example.dbuser.presenter

import android.content.Context
import com.example.dbuser.dataModel.UserDto
import com.example.dbuser.interfaces.IOperacioensInteractor
import com.example.dbuser.interfaces.IOperacionesPresenter
import com.example.dbuser.interfaces.IOperacionesView
import com.example.dbuser.model.InteractorOperacionesImpl

class OperacionesPresenterImpl(view: IOperacionesView,context: Context): IOperacionesPresenter {

    private var interactor: IOperacioensInteractor
    private var view:IOperacionesView

    init {
        this.view = view
        interactor = InteractorOperacionesImpl(this,context)
    }

    override fun showResult(result: String) {

    }

    override fun insertUser(userDto: UserDto): Long {
        return interactor.insertUser(userDto)
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