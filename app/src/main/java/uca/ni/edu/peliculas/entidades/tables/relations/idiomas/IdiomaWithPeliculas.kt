package uca.ni.edu.peliculas.entidades.tables.relations.idiomas

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import uca.ni.edu.peliculas.entidades.tables.Idioma
import uca.ni.edu.peliculas.entidades.tables.Pelicula

data class IdiomaWithPeliculas(
    @Embedded val idioma: Idioma,
    @Relation(
        parentColumn = "idIdioma",
        entityColumn = "idPelicula",
        associateBy = Junction(PeliculaIdioma::class)
    )
    val peliculas:List<Pelicula>
)
