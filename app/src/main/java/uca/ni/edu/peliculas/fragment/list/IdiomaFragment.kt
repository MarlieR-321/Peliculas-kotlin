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
import uca.ni.edu.peliculas.adapters.Idioma_Adapter
import uca.ni.edu.peliculas.dao.PeliculaDao
import uca.ni.edu.peliculas.databinding.FragmentIdiomaBinding
import uca.ni.edu.peliculas.dbPeliculas


class IdiomaFragment : Fragment() {
    lateinit var binding: FragmentIdiomaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentIdiomaBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = Navigation.findNavController(view)
        val db: dbPeliculas = dbPeliculas.getInstace(this.requireContext().applicationContext)
        val dao: PeliculaDao = db.peliculaDao()

        CoroutineScope(Dispatchers.Main).launch {
            var listU = dao.getAllIdioma()

            binding.rvClasificacion.layoutManager = LinearLayoutManager(context)
            val adapter = Idioma_Adapter(listU)
            binding.rvClasificacion.adapter = adapter
        }

        binding.btnAdd.setOnClickListener {
            navController.navigate(R.id.idioma_to_addI)
        }
    }
}