package com.abhishek.kotlinpractice2026

import android.content.Intent
import android.os.Binder
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.abhishek.kotlinpractice2026.databinding.LoginScreenBinding
import com.google.android.material.button.MaterialButton

class LoginScreen : AppCompatActivity() {

//    lateinit var etUser : EditText
//    lateinit var etnpass : EditText
//    lateinit var etButton : MaterialButton

    lateinit var binding : LoginScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
       setContentView(R.layout.login_screen)
        binding = LoginScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
//        etUser = findViewById(R.id.etUser)
//        etpass = findViewById(R.id.etPass)
//        etButton = findViewById(R.id.etButton)

        intent.let {
            binding.etUser.setText(it.getStringExtra("name")?:"")
        }

        intent.let {
            binding.password.setText(it.getStringExtra("cmPassword")?:"")
        }

        binding.createAccount.setOnClickListener {
             intent = Intent(this,CreateAccount::class.java)
            startActivity(intent)
            finish()
        }
        binding.etButton.setOnClickListener {
            if(binding.etUser.text.toString().isEmpty()){
                binding.etUser.error = "Enter Username"
            }else if (binding.password.text.toString().isEmpty()){
                binding.password.error = "Enter password"
            }else{
                Toast.makeText(this,"Login Successfully",Toast.LENGTH_SHORT).show()
            }
        }
        Toast.makeText(this, "create", Toast.LENGTH_SHORT).show()
    }
}