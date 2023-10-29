package net.iesochoa.pacofloridoquesada.practica4ejemplo1

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import net.iesochoa.pacofloridoquesada.practica4ejemplo1.databinding.FragmentCambiaNombreBinding
import net.iesochoa.pacofloridoquesada.practica4ejemplo1.databinding.FragmentSaludoBinding


class CambiaNombreFragment : Fragment() {
    private var _binding: FragmentCambiaNombreBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    val args:CambiaNombreFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        _binding = FragmentCambiaNombreBinding.inflate(inflater, container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)

        // Busco el nombre a cambiar en los argumentos recibidos
        binding.etCambiaNombre.setText(args.nombreCambiar)

        // Creo la acción del botón btCambiaNom
        binding.btCambiaNom.setOnClickListener{
            // Cojo el nombre del EditText
            val nombre = binding.etCambiaNombre.text.toString()

            // Pasamo el nombre como argumento a SaludoFragment
            val action = CambiaNombreFragmentDirections.actionCambiaNombreFragmentToSaludoFragment(nombre)
            // Ejecutamos la acción
            findNavController().navigate(action)
        }


    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}