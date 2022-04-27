package uca.ni.edu.peliculas.fragment.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uca.ni.edu.peliculas.R
import uca.ni.edu.peliculas.bd.dao.PeliculaDao
import uca.ni.edu.peliculas.databinding.FragmentAddClasificacionBinding
import uca.ni.edu.peliculas.bd.dao.dbPeliculas
import uca.ni.edu.peliculas.bd.entidades.tables.Clasificacion

class AddClasificacionFragment : Fragment() {

    private lateinit var binding:FragmentAddClasificacionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentAddClasificacionBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = Navigation.findNavController(view)
        val db: dbPeliculas = dbPeliculas.getInstace(this.requireContext().applicationContext)
        val dao: PeliculaDao = db.peliculaDao()

        with(binding){
            btnNew.setOnClickListener {

                val cl = Clasificacion(0,etAbreviacion.text.toString(),etNombre.text.toString(), true)

                CoroutineScope(Dispatchers.Main).launch {
                    dao.insertClasificacion(cl)
                }
                navController.navigate(R.id.addC_to_clasificacion)

            }
        }
    }

}