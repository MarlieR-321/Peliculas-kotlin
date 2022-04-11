package uca.ni.edu.peliculas.entidades.tables

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="Genero")
data class Genero (
    @PrimaryKey(autoGenerate = true)
    val id_Genero:Int,
    @ColumnInfo(name = "nombre")
    val nombre:String,
    @ColumnInfo(name = "activo")
    val activo:Boolean
        )