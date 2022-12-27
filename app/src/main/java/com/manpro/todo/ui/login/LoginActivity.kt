package com.manpro.todo.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.manpro.todo.R
import com.manpro.todo.databinding.ActivityLoginBinding
import com.manpro.todo.ui.base.BaseActivity
import com.manpro.todo.ui.main.MainActivity
import com.manpro.todo.ui.register.RegisterActivity

class LoginActivity : BaseActivity<ActivityLoginBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.btnSignin.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

            finishAffinity()

        }

        binding.tvRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

    }

    override fun getViewBinding(): ActivityLoginBinding  = ActivityLoginBinding.inflate(layoutInflater)
}