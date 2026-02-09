package com.abhishek.kotlinpractice2026

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.abhishek.kotlinpractice2026.databinding.ActivityFragmentBinding
import com.abhishek.kotlinpractice2026.databinding.ActivityRadioButtonBinding


class RadioButtonActivity : AppCompatActivity() {
    lateinit var binding: ActivityRadioButtonBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRadioButtonBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.radio1.setOnClickListener {
            binding.radio1.isChecked = true
            binding.radio2.isChecked = false
            binding.radio3.isChecked = false
        }

        binding.radio2.setOnClickListener {
            binding.radio2.isChecked = true
            binding.radio1.isChecked = false
            binding.radio3.isChecked = false
        }

        binding.radio3.setOnClickListener {
            binding.radio2.isChecked = false
            binding.radio1.isChecked = false
            binding.radio3.isChecked = true
        }

    }
}

