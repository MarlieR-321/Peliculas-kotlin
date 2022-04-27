package uca.ni.edu.peliculas.bd.dao

import androidx.room.*
import uca.ni.edu.peliculas.bd.entidades.tables.*

@Dao
interface ClasificacionDao {
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


}