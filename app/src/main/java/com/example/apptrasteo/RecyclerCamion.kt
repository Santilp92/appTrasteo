package com.example.apptrasteo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerCamion(private var listaCamiones: MutableList<Camion>): RecyclerView.Adapter<RecyclerCamion.MiHolder>() {


    inner class MiHolder (itemView: View): RecyclerView.ViewHolder(itemView){
        var  nombres: TextView
        var  ciudad: TextView
        var  telefono: TextView
        var imagen: ImageView

        init {
            nombres = itemView.findViewById(R.id.nombreConductor)
            ciudad = itemView.findViewById(R.id.ciudadConductor)
            telefono = itemView.findViewById(R.id.telefonoConductor)
            imagen = itemView.findViewById(R.id.fotoConductor)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MiHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_camion,parent,false)
        return MiHolder(itemView)
    }

    override fun onBindViewHolder(holder: MiHolder, position: Int) {

        val camion = listaCamiones[position]
        holder.nombres.text = camion.nombre
        holder.telefono.text = camion.telefono
        holder.ciudad.text = camion.ciudad
        holder.imagen.setImageResource(camion.foto)

    }

    override fun getItemCount(): Int {
        return listaCamiones.size
    }
}