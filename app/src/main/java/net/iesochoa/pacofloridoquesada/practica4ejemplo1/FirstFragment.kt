package net.iesochoa.pacofloridoquesada.practica4ejemplo1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import net.iesochoa.pacofloridoquesada.practica4ejemplo1.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btNext.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
        // llamada a SaludoFragment
        binding.btSaludo.setOnClickListener(){
            // findNavController().navigate(R.id.action_FirstFragment_to_saludoFragment)

            // Buscamos el nombre
            val nombre = binding.etNombre.text.toString()
            // Creamos la accion pasandole el nombre como argumento
            val action = FirstFragmentDirections.actionFirstFragmentToSaludoFragment(nombre)
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}