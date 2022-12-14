package com.testing.pixelwikiapp

class BudgetUserRepository {
    // giga cheap way to simulate real work with API and bases
    var loginUser: User? = null

    fun login (email: String, password: String){

        val user = getUserFromRemoteServer(email, password)
        loginUser = user
    }

    private fun getUserFromRemoteServer(email: String, password: String ): User? {
        return if (email == "admin@admin.com" && password == "12345") {
            User(email, password, "Moderator№718")
        } else {
            null
        }
    }
}