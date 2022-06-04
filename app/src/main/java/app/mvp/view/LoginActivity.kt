package app.mvp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.mvp.contracts.LoginContract
import app.mvp.databinding.ActivityLoginBinding
import app.mvp.presenter.LoginPresenter
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity(), LoginContract.LoginView {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var loginPresenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initPresenter()
    }

    private fun initPresenter() {
        loginPresenter = LoginPresenter(this)

        binding.btnLogin.setOnClickListener {
            loginPresenter.login(
                binding.nameEditText.text.toString(),
                binding.passwordEdittext.text.toString()
            )
        }

    }

    override fun onSuccess(message: String) {
        Snackbar.make(binding.layout, "Hello Omar", Snackbar.LENGTH_LONG).show()
    }

    override fun onFailed(message: String) {
        Snackbar.make(
            binding.layout, "Please Check User Name or Password", Snackbar.LENGTH_LONG
        ).show()
    }
}