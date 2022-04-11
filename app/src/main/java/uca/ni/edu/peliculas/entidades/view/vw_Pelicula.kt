package uca.ni.edu.peliculas.entidades.view

import androidx.room.DatabaseView

@DatabaseView("Select " +
                    "p.idPelicula," +
                    "p.titulo," +
                    "p.sinopsis," +
                    "p.tipoMetraje," +
                    "p.duracion," +
                    "c.nombre as clasificacion," +
                    "n.nombre as nacionalidad " +
                    "from Pelicula as p " +
                    "inner join Nacionalidad as n on n.id_Nacionalidad=p.idNacionalidad " +
                    "inner join Clasificacion as c on c.idClasificacion=p.idClasificacion")
data class vw_Pelicula(
    val idPelicula: Int,
    val titulo: String,
    val sinopsis: String,
    val tipoMetraje: String,
    val duracion: String,
    val clasificacion: String,
    val nacionalidad: String
)
