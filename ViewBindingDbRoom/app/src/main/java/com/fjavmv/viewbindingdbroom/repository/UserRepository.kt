package com.fjavmv.viewbindingdbroom.repository

import android.content.Context
import androidx.room.Room
import com.fjavmv.viewbindingdbroom.db.AppDatabase
import com.fjavmv.viewbindingdbroom.entidad.User


private const val DATABASE_NAME = "user-database.db"

class UserRepository private constructor(context: Context){

    private val dbRoom: AppDatabase = Room.databaseBuilder(
        context.applicationContext,
        AppDatabase:: class.java,
        DATABASE_NAME
    ).build()

    private val userDao = dbRoom.userDao()

    suspend fun getAll(): List<User> = userDao.getAll()

    suspend fun loadAllByIds(userIds: IntArray): List<User> = userDao.loadAllByIds(userIds)

    //Consulatar por nombre y apellido
    suspend fun findByName(first: String, last: String): User = userDao.findByName(first,last)

    //Para pasar un número variable de argumentos a una función, debemos declarar esa función con un   parámetro vararg
    suspend fun insertAll(user: User) = userDao.insertAll(user = user)

    suspend fun delete(user: User) = userDao.delete(user)

    companion object{
        private var INSTANCE: UserRepository? = null

        fun inicializar(context: Context){
            if(INSTANCE == null){
                INSTANCE = UserRepository(context)
            }
        }

        fun get(): UserRepository{
            return INSTANCE ?: throw IllegalStateException("UserRepository debe ser inicializado")
        }
    }

    //UserRepository es una clase de tipo singleton
    /*
        Singnifica que habrá solo una intancia de esta clase en el proceso principal
        de la app
     */


}