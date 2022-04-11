package uca.ni.edu.peliculas.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uca.ni.edu.peliculas.R
import uca.ni.edu.peliculas.entidades.tables.Genero

class Genero_Adapter(val compra:List<Genero>):RecyclerView.Adapter<Genero_Adapter.GeneroHolder>()  {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GeneroHolder {
        var view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_list, null, false)
        return GeneroHolder(view)
    }

    override fun onBindViewHolder(holder: GeneroHolder, position: Int) {
        val current =compra[position]
        holder.tvTitulo.text = current.nombre
        holder.tvSubtitulo.text ="ID = ${ current.id_Genero.toString()}"
    }

    override fun getItemCount(): Int = compra.size

    class GeneroHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitulo: TextView = itemView.findViewById(R.id.item_title)
        val tvSubtitulo: TextView = itemView.findViewById(R.id.item_sub)

    }

}