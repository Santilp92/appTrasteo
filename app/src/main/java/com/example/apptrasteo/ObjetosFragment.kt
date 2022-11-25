package com.example.apptrasteo

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet.Constraint
import com.example.apptrasteo.databinding.FragmentObjetosBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton


/**
 * A simple [Fragment] subclass.
 * Use the [ObjetosFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ObjetosFragment : Fragment(R.layout.fragment_objetos) {
    private var _binding: FragmentObjetosBinding? = null
    private val binding get() = _binding!!
    private var fab: FloatingActionButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentObjetosBinding.inflate(inflater)
        var view: ConstraintLayout = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var intent = Intent(context, RegistrarObjeto::class.java)
        if(arguments != null){
            val email = requireArguments().getString("email")
            intent.putExtra("email", email)
        }
        fab = binding.agregar
        fab!!.setOnClickListener {
            startActivity(intent)
        }
    }
}