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
import uca.ni.edu.peliculas.dao.PeliculaDao
import uca.ni.edu.peliculas.databinding.FragmentAddIdiomaBinding
import uca.ni.edu.peliculas.dbPeliculas
import uca.ni.edu.peliculas.entidades.tables.Idioma

class AddIdiomaFragment : Fragment() {

    private lateinit var binding:FragmentAddIdiomaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentAddIdiomaBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = Navigation.findNavController(view)
        val db: dbPeliculas = dbPeliculas.getInstace(this.requireContext().applicationContext)
        val dao: PeliculaDao = db.peliculaDao()

        with(binding){
            btnNew.setOnClickListener {

                val id = Idioma(0,etNombre.text.toString(), true)

                CoroutineScope(Dispatchers.Main).launch {
                    dao.insertIdioma(id)
                }
                navController.navigate(R.id.addI_to_idioma)

            }
        }
    }

}