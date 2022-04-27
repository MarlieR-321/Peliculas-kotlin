package uca.ni.edu.peliculas.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uca.ni.edu.peliculas.R
import uca.ni.edu.peliculas.bd.entidades.tables.Nacionalidad

class Nacionalidad_Adapter(val compra:List<Nacionalidad>):RecyclerView.Adapter<Nacionalidad_Adapter.NacionalidadHolder>()  {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NacionalidadHolder {
        var view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_list, null, false)
        return NacionalidadHolder(view)
    }

    override fun onBindViewHolder(holder: NacionalidadHolder, position: Int) {
        val current =compra[position]
        holder.tvTitulo.text = current.nombre
        holder.tvSubtitulo.text ="ID = ${ current.id_Nacionalidad.toString()}"
    }

    override fun getItemCount(): Int = compra.size

    class NacionalidadHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitulo: TextView = itemView.findViewById(R.id.item_title)
        val tvSubtitulo: TextView = itemView.findViewById(R.id.item_sub)

    }

}