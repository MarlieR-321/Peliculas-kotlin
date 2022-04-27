package uca.ni.edu.peliculas.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uca.ni.edu.peliculas.R
import uca.ni.edu.peliculas.bd.entidades.tables.Clasificacion

class Clasificacion_Adapter(val compra: List<Clasificacion>):RecyclerView.Adapter<Clasificacion_Adapter.ClasificacionHolder>()  {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ClasificacionHolder {
        var view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_list, null, false)
        return ClasificacionHolder(view)
    }

    override fun onBindViewHolder(holder: ClasificacionHolder, position: Int) {
        val current =compra[position]
        holder.tvTitulo.text = current.abreviacion
        holder.tvSubtitulo.text = current.nombre


    }

    override fun getItemCount(): Int = compra.size

    class ClasificacionHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitulo: TextView = itemView.findViewById(R.id.item_title)
        val tvSubtitulo: TextView = itemView.findViewById(R.id.item_sub)
        val ll:LinearLayout = itemView.findViewById(R.id.ll_item)
    }

}