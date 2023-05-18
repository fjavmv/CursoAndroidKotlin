package com.fjavmv.viewbindingdbroom.db.dao


import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.fjavmv.viewbindingdbroom.entidad.User


//Objeto de acceso a datos (DAO)
@Dao
interface UserDao {
    //Recuperamos todos los datos del usuario
    @Query("SELECT * FROM users")
    suspend fun getAll(): List<User>

    //Consulta por ID
    @Query("SELECT * FROM users WHERE uid IN (:userIds)")
    suspend fun loadAllByIds(userIds: IntArray): List<User>

    //Consulatar por nombre y apellido
    @Query("SELECT * FROM users WHERE first_name LIKE :first AND " + "last_name LIKE :last LIMIT 1")
    suspend fun findByName(first: String, last: String): User

    //Para pasar un número variable de argumentos a una función, debemos declarar esa función con un   parámetro vararg
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    //fun insertAll(vararg user: User)
    suspend fun insertAll(user: User)

    @Delete
    suspend fun delete(user: User)
}