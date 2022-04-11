package uca.ni.edu.peliculas.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import uca.ni.edu.peliculas.R
import uca.ni.edu.peliculas.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {

    private lateinit var binding:FragmentMenuBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding){
            btnClasificacion.setOnClickListener {
                findNavController().navigate(R.id.clasificacionFragment)
            }

            btnIdioma.setOnClickListener {
                findNavController().navigate(R.id.idiomaFragment)
            }
            btnGenero.setOnClickListener {
                findNavController().navigate(R.id.generoFragment)
            }
            btnNacionalidad.setOnClickListener {
                findNavController().navigate(R.id.nacionalidadFragment)
            }
            btnPelicula.setOnClickListener {
                findNavController().navigate(R.id.peliculaFragment)
            }

        }
    }

}