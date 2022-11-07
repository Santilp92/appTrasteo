package com.example.apptrasteo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.apptrasteo.databinding.ActivityLoginBinding
import com.example.apptrasteo.databinding.ActivityRecuperarBinding

class RecuperarActivity: AppCompatActivity() {

    private lateinit var binding: ActivityRecuperarBinding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityRecuperarBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}