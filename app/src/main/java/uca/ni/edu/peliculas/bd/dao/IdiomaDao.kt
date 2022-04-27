package uca.ni.edu.peliculas.bd.dao

import androidx.room.*
import uca.ni.edu.peliculas.bd.entidades.tables.*
import uca.ni.edu.peliculas.bd.entidades.tables.relations.genero.PeliculaGenero
import uca.ni.edu.peliculas.bd.entidades.view.vw_Pelicula

@Dao
interface IdiomaDao {

    //IDIOMA
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertIdioma(usuario: Idioma)

    @Query("Select * from Idioma")
    suspend fun getAllIdioma(): List<Idioma>

    @Query("SELECT * FROM Idioma where id_Idioma= :id")
    suspend fun getByIdIdioma(id: Int): Idioma

    @Update
    fun updateIdioma(usuario: Idioma)

    @Delete
    fun deleteIdioma(usuario: Idioma)

}