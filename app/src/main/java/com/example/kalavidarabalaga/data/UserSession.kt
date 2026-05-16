package com.example.kalavidarabalaga.data

object UserSession {

    var userName: String = ""

    var userEmail: String = ""

    var userPhone: String = ""

    var userPassword: String = ""

    var isLoggedIn: Boolean = false

    fun clearSession() {

        userName = ""

        userEmail = ""

        userPhone = ""

        userPassword = ""

        isLoggedIn = false
    }
}