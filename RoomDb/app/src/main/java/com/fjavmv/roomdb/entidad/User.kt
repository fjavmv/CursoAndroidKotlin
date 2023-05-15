package com.fjavmv.roomdb.entidad

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
//@PrimaryKey(autoGenerate = true)
data class User(@ColumnInfo(name = "uid") @PrimaryKey(autoGenerate = true) val uid: Int){
    @ColumnInfo(name = "first_name") lateinit var firstName: String
    @ColumnInfo(name = "last_name")  lateinit var lastName: String
    @ColumnInfo(name =  "age") lateinit var age: String

    constructor(
                firstName: String,
                lastName: String,
                age: String
    ):this(0){
        this.firstName = firstName
        this.lastName = lastName
        this.age = age
                }

    override fun toString(): String {
        return "Nombre: $firstName Apellido: $lastName Edad: $age"
    }
}
