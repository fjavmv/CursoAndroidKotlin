package com.example.dbuser.dataModel

data class UserDto(var idUser: Long = 0){
    lateinit var name: String
    lateinit var lastName: String
    lateinit var phoneNumber: String
    lateinit var userEmail: String

    constructor(idUser: Long, name: String, lastName: String, phoneNumber: String, userEmail: String) : this(idUser){
        this.idUser = idUser
        this.name = name
        this.lastName = lastName
        this.phoneNumber = phoneNumber
        this.userEmail = userEmail
    }
    constructor(name: String, lastName: String,phoneNumber: String, userEmail: String): this() {
        this.name = name
        this.lastName = lastName
        this.phoneNumber = phoneNumber
        this.userEmail = userEmail
    }

    override fun toString(): String {
        return "Id usuario: $idUser Nombre usuario: $name $ Apellidos: $lastName Teléfono: $phoneNumber Email: $userEmail"
    }
}
