package uca.ni.edu.peliculas.entidades.tables.relations.genero

import androidx.room.Entity

@Entity(primaryKeys = ["idGenero","idPelicula"])
data class PeliculaGenero(
    val idGenero:Int,
    val idPelicula:Int
)
