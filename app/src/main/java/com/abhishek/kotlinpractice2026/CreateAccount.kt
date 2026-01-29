package com.abhishek.kotlinpractice2026

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.abhishek.kotlinpractice2026.databinding.CreateAccountBinding
import java.util.zip.Inflater



class CreateAccount : AppCompatActivity() {

    lateinit var binding: CreateAccountBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.create_account)
        binding = CreateAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.createButton.setOnClickListener {

                val name = binding.etUser.text.toString()
                val Password = binding.password.text.toString()
                val cmPassword = binding.cmPassword.text.toString()

            if (binding.cmPassword.text.toString()!=Password){
                binding.cmPassword.error = "Enter Correct Password"
            }else{
                val intent = Intent(this, LoginScreen::class.java)
                intent.putExtra("name",name)
                intent.putExtra("cmPassword",cmPassword)
                startActivity(intent)
                finish()
                Toast.makeText(this,"Create Account Successfully",Toast.LENGTH_SHORT).show()
            }
        }
    }
}


