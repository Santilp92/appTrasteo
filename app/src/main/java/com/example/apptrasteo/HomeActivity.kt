package com.example.apptrasteo

import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import com.example.apptrasteo.databinding.ActivityHomeBinding


class HomeActivity: AppCompatActivity(){

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val email = intent.getStringExtra("email")
        Toast.makeText(this,"Bienvenido $email", Toast.LENGTH_LONG).show()
        val objetos_F = ObjetosFragment()
        val camiones_F = CamionesFragment()
        val viajes_F = ViajesFragment()
        val cuenta_F = CuentaFragment()

        val bundle = Bundle()
        bundle.putString("email", email)
        objetos_F.arguments = bundle

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.objects ->{
                    menuInferior(objetos_F)
                    true
                }
                R.id.truck->{
                    menuInferior(camiones_F)
                    true
                }
                R.id.trip ->{
                    menuInferior(viajes_F)
                    true
                }
                R.id.account ->{
                    menuInferior(cuenta_F)
                    true
                }
                else-> false
            }
        }
    }

    private fun menuInferior(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainerView, fragment)
            commit()
        }
    }
}