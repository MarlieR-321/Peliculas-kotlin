package uca.ni.edu.peliculas.fragment.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uca.ni.edu.peliculas.R
import uca.ni.edu.peliculas.adapters.Pelicula_Adapter
import uca.ni.edu.peliculas.bd.dao.PeliculaDao
import uca.ni.edu.peliculas.databinding.FragmentPeliculaBinding
import uca.ni.edu.peliculas.bd.dao.dbPeliculas


class PeliculaFragment : Fragment() {

    lateinit var binding: FragmentPeliculaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPeliculaBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = Navigation.findNavController(view)
        val db: dbPeliculas = dbPeliculas.getInstace(this.requireContext().applicationContext)
        val dao: PeliculaDao = db.peliculaDao()

        CoroutineScope(Dispatchers.Main).launch {
            var list = dao.getAllVw_Pelicula()
            val adapter = Pelicula_Adapter(list)
            binding.rvClasificacion.adapter = adapter
        }
        binding.rvClasificacion.layoutManager = LinearLayoutManager(context)

        binding.btnAdd.setOnClickListener{
            navController.navigate(R.id.pelicula_toAddP)
        }
    }
}