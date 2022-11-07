package com.example.apptrasteo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.apptrasteo.databinding.ActivityRegistrarBinding

class RegistrarActivity: AppCompatActivity() {

    private lateinit var binding: ActivityRegistrarBinding


    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.registrarLocal.setOnClickListener{guardarUsuario()}
    }

    private fun guardarUsuario(){
        val nombre:String = binding.nombre.text.toString()
        val apellidos:String = binding.apellidos.text.toString()
        val telefono:String = binding.telefono.text.toString()
        val direccion:String = binding.direccion.text.toString()
        val correo:String = binding.correo.text.toString()
        val clave:String = binding.clave.text.toString()
        val genero:Int = binding.genero.id

        var pref = getSharedPreferences(correo,Context.MODE_PRIVATE)
        var editar = pref.edit()

        editar.putString("nombre",nombre)
        editar.putString("apellidos",apellidos)
        editar.putString("telefono",telefono)
        editar.putString("direccion",direccion)
        editar.putString("email",correo)
        editar.putString("clave",clave)
        if(genero == 0){
            editar.putString("genero", "Femenino")
        }else {
            editar.putString("genero", "Masculino")
        }
        editar.commit()
        Toast.makeText(this,"Usuario registrado exitosamente", Toast.LENGTH_LONG).show()
        startActivity((Intent(this,LoginActivity::class.java)))
    }
}