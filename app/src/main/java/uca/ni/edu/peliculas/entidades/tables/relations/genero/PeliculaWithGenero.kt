package uca.ni.edu.peliculas.entidades.tables.relations.genero

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import uca.ni.edu.peliculas.entidades.tables.Genero
import uca.ni.edu.peliculas.entidades.tables.Pelicula

data class PeliculaWithGenero(
    @Embedded val pelicula: Pelicula,
    @Relation(
        parentColumn = "idPelicula",
        entityColumn = "idIdioma",
        associateBy = Junction(PeliculaGenero::class)
    )
    val genero:List<Genero>
)
