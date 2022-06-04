package app.mvp.contracts

interface LoginContract {

    interface LoginView {
        fun onSuccess(message: String)
        fun onFailed(message: String)
    }

    interface LoginPresenter {
        fun login(username: String, password: String)
    }


}