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
        //Pasamos al interactor un instancia del presentador y el contexto de la aplicación
        interactor = InteractorOperacionesImpl(this,context)
    }

    //Pasamos al interactor los elementos a insertar
    override fun insertUser(userDto: UserDto) {
        interactor.insertUser(userDto)
    }

    //Pasamos a la vista el resultado de la inserción
    override fun showResultInsert(result: Int) {
        view.showResultInsert(result)
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