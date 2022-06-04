package app.mvp.database

import app.mvp.model.User

object UserDatabase {

    fun getCurrentUser(): User {
        return User("Omar", "1234")
    }

}