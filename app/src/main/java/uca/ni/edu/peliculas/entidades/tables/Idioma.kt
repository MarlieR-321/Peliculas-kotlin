package uca.ni.edu.peliculas.entidades.tables

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="Idioma")
data class Idioma (
    @PrimaryKey(autoGenerate = true)
    val id_Idioma:Int,
    @ColumnInfo(name = "nombre")
    val nombre:String,
    @ColumnInfo(name = "activo")
    val activo:Boolean
        )