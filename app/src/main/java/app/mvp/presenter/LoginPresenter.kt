package app.mvp.presenter

import app.mvp.contracts.LoginContract
import app.mvp.database.UserDatabase

class LoginPresenter(
    private val loginView: LoginContract.LoginView
) : LoginContract.LoginPresenter {
    override fun login(username: String, password: String) {
        if (username == UserDatabase.getCurrentUser().user_name && password == UserDatabase.getCurrentUser().password) {
            loginView.onSuccess("Success")
        } else
            loginView.onFailed("Login Failed")
    }
}