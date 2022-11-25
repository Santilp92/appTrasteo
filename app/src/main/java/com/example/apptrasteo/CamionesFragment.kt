package com.example.apptrasteo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apptrasteo.databinding.FragmentCamionesBinding

class CamionesFragment : Fragment() {
    private var _binding:FragmentCamionesBinding? = null
    private val binding get() = _binding!!
    private var lista: MutableList<Camion> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCamionesBinding.inflate(inflater)
        var view: FrameLayout = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lista.add(Camion("Pedro Gomez", "3127932323", "Bogota", R.drawable.logoicon))
        lista.add(Camion("Juan Perez", "23423423", "Medellín", R.drawable.logoicon))
        lista.add(Camion("Carlos Gutierrez", "2342342342", "Pereira", R.drawable.logoicon))
        lista.add(Camion("Pablo Ramirez", "432423432", "Barranquilla", R.drawable.logoicon))

        binding.listaCamiones.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = RecyclerCamion(lista)
        }
    }

}