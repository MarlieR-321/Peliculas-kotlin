package uca.ni.edu.peliculas

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uca.ni.edu.peliculas.dao.PeliculaDao
import uca.ni.edu.peliculas.entidades.tables.*
import uca.ni.edu.peliculas.entidades.tables.relations.genero.PeliculaGenero
import uca.ni.edu.peliculas.entidades.tables.relations.idiomas.PeliculaIdioma
import uca.ni.edu.peliculas.entidades.view.vw_Pelicula

interface MainDataBaseProvider{
    fun peliculaDao() : PeliculaDao
}

@Database(entities = [Clasificacion::class , Nacionalidad::class, Idioma::class, Genero::class,Pelicula::class,PeliculaGenero::class,PeliculaIdioma::class],
    views = [vw_Pelicula::class],
    version = 4
)
abstract class dbPeliculas: RoomDatabase(), MainDataBaseProvider {
    abstract override fun peliculaDao(): PeliculaDao

    companion object{
        @Volatile
        private var INSTANCE: dbPeliculas? = null
        fun getInstace(context: Context): dbPeliculas {
            synchronized(this){
                var instance = INSTANCE
                if (instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        dbPeliculas::class.java,
                        "dbMovies"
                    ).fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
