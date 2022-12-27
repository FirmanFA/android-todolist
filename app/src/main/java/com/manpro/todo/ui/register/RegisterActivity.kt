package com.manpro.todo.ui.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.manpro.todo.R
import com.manpro.todo.databinding.ActivityRegisterBinding
import com.manpro.todo.ui.base.BaseActivity
import com.manpro.todo.ui.login.LoginActivity
import com.manpro.todo.ui.main.MainActivity

class RegisterActivity : BaseActivity<ActivityRegisterBinding>() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.btnRegister.setOnClickListener {
            Toast.makeText(this, "Register berhasil", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finishAffinity()
        }


    }

    override fun getViewBinding(): ActivityRegisterBinding =
        ActivityRegisterBinding.inflate(layoutInflater)
}