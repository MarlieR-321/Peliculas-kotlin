package uca.ni.edu.peliculas.bd.dao

import androidx.room.*
import uca.ni.edu.peliculas.bd.entidades.tables.*
import uca.ni.edu.peliculas.bd.entidades.tables.relations.genero.PeliculaGenero
import uca.ni.edu.peliculas.bd.entidades.view.vw_Pelicula

@Dao
interface PeliculaDao {
    //CLASIFICACION
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertClasificacion(usuario: Clasificacion)

    @Query("Select * from Clasificacion")
    suspend fun getAllClasificacion(): List<Clasificacion>

    @Query("SELECT * FROM Clasificacion where idClasificacion= :id")
    suspend fun getByIdClasificacion(id: Int): Clasificacion

    @Update
    fun updateClasificacion(usuario: Clasificacion)

    @Delete
    fun deleteClasificacion(usuario: Clasificacion)

    //GENERO
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGenero(usuario: Genero)

    @Query("Select * from Genero")
    suspend fun getAllGenero(): List<Genero>

    @Query("SELECT * FROM Genero where id_Genero= :id")
    suspend fun getByIdGenero(id: Int): Genero

    @Update
    fun updateGenero(usuario: Genero)

    @Delete
    fun deleteGenero(usuario: Genero)

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

    //NACIONALIDAD
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNacionalidad(usuario: Nacionalidad)

    @Query("Select * from Nacionalidad")
    suspend fun getAllNacionalidad(): List<Nacionalidad>

    @Query("SELECT * FROM Nacionalidad where id_Nacionalidad= :id")
    suspend fun getByIdNacionalidad(id: Int): Nacionalidad

    @Update
    fun updateNacionalidad(usuario: Nacionalidad)

    @Delete
    fun deleteNacionalidad(usuario: Nacionalidad)

    //VW_PELICULA
    @Query("Select * from vw_Pelicula")
    suspend fun getAllVw_Pelicula(): List<vw_Pelicula>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPelicula(usuario: Pelicula)

    @Query("Select * from PeliculaGenero")
    suspend fun getAllByIdPeliculaGenero(): List<PeliculaGenero>

    //SPINERS
    @Query("SELECT id_Nacionalidad FROM Nacionalidad where nombre= :nombre")
    suspend fun getByStringNacionalidad(nombre: String): Int

    @Query("SELECT idClasificacion FROM Clasificacion where abreviacion= :abreviacion")
    suspend fun getByStringClasificacion(abreviacion: String): Int

}