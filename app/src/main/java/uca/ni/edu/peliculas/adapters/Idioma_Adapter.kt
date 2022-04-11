package uca.ni.edu.peliculas.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uca.ni.edu.peliculas.R
import uca.ni.edu.peliculas.entidades.tables.Idioma

class Idioma_Adapter(val compra:List<Idioma>):RecyclerView.Adapter<Idioma_Adapter.IdiomaHolder>()  {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): IdiomaHolder {
        var view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_list, null, false)
        return IdiomaHolder(view)
    }

    override fun onBindViewHolder(holder: IdiomaHolder, position: Int) {
        val current =compra[position]
        holder.tvTitulo.text = current.nombre
        holder.tvSubtitulo.text ="ID = ${ current.id_Idioma.toString()}"
    }

    override fun getItemCount(): Int = compra.size

    class IdiomaHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitulo: TextView = itemView.findViewById(R.id.item_title)
        val tvSubtitulo: TextView = itemView.findViewById(R.id.item_sub)

    }

}