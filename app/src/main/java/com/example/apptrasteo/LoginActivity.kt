package com.example.apptrasteo

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import com.example.apptrasteo.databinding.ActivityLoginBinding
import androidx.appcompat.app.AppCompatActivity

class LoginActivity: AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding


    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.ingresar.setOnClickListener{validar()}
        binding.registrar.setOnClickListener{enviarRegistrar()}
        binding.recordar.setOnClickListener{recuperar()}
    }

    private fun validar(){
        val email:String = binding.email.text.toString()
        val clave:String = binding.password.text.toString()

        var pref =  getSharedPreferences(email,Context.MODE_PRIVATE)
        var email_bd = pref.getString("email", "")
        var pass_bd = pref.getString("clave", "")
        var nombre_bd = pref.getString("nombre", "")
        var apellido_bd = pref.getString("apellidos", "")

        if(email.isEmpty()){
            binding.email.hint = "Correo electrónico"
            binding.email.setHintTextColor(Color.RED)
            Toast.makeText(this,"Ingrese su correo", Toast.LENGTH_LONG).show()
        }else if (clave.isEmpty()){
            binding.password.hint = "Contraseña"
            binding.password.setHintTextColor(Color.RED)
            Toast.makeText(this,"Ingrese su contraseña", Toast.LENGTH_LONG).show()
        }else if(email == email_bd){
            if(clave == pass_bd){
                Toast.makeText(this,"Bienvenido $nombre_bd $apellido_bd", Toast.LENGTH_LONG).show()
                var intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("email", email_bd)
                startActivity(intent)
            }else{
                Toast.makeText(this,"Contraseña Incorrecta", Toast.LENGTH_LONG).show()
            }
        }else{
            Toast.makeText(this,"Correo Incorrecto", Toast.LENGTH_LONG).show()
        }
    }

    private fun enviarRegistrar(){
        startActivity(Intent(this, RegistrarActivity::class.java))
    }

    private fun recuperar(){
        startActivity(Intent(this, RecuperarActivity::class.java))
    }
}