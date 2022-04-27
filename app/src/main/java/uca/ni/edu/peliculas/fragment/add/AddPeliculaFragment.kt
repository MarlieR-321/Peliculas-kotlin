package uca.ni.edu.peliculas.fragment.add

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.Navigation
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uca.ni.edu.peliculas.R
import uca.ni.edu.peliculas.bd.dao.PeliculaDao
import uca.ni.edu.peliculas.databinding.FragmentAddPeliculaBinding
import uca.ni.edu.peliculas.bd.dao.dbPeliculas
import uca.ni.edu.peliculas.bd.entidades.tables.Pelicula


class AddPeliculaFragment : Fragment() {

    lateinit var binding:FragmentAddPeliculaBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentAddPeliculaBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val context = this.requireContext().applicationContext

        initSpinner(context)

        val db: dbPeliculas = dbPeliculas.getInstace(context!!)
        val dao: PeliculaDao = db.peliculaDao()
        val navController = Navigation.findNavController(view)

        with(binding){
            btnNew.setOnClickListener{

                CoroutineScope(Dispatchers.Main).launch {
                    val idN = dao.getByStringNacionalidad(spNacionalidad.selectedItem.toString())
                    val idC = dao.getByStringClasificacion(spClasificacion.selectedItem.toString())

                    val peli = Pelicula(0,idC,etDuracion.text.toString(),idN,etSinopsis.text.toString(), etTipoMetraje.text.toString(),etTitulo.text.toString())
                    dao.insertPelicula(peli)
                }
                navController.navigate(R.id.addP_toPelicula)
            }
        }


    }

    private fun initSpinner(context:Context){
        val db: dbPeliculas = dbPeliculas.getInstace(context)
        val dao: PeliculaDao = db.peliculaDao()
        CoroutineScope(Dispatchers.Main).launch {
            var listN = dao.getAllNacionalidad()
            var arrayNac:ArrayList<String> = arrayListOf("Seleccione..")

            listN.forEach {
                arrayNac.add(it.nombre)
            }

            var listC = dao.getAllClasificacion()
            var arrayAbr:ArrayList<String> = arrayListOf("Seleccione..")

            listC.forEach {
                arrayAbr.add(it.abreviacion)
            }


            var adapterN: ArrayAdapter<String> = ArrayAdapter<String>(context,R.layout.sp_item, arrayNac)
            binding.spNacionalidad.adapter = adapterN

            var adapterC: ArrayAdapter<String> = ArrayAdapter<String>(context,R.layout.sp_item, arrayAbr)
            binding.spClasificacion.adapter = adapterC
        }
    }


}