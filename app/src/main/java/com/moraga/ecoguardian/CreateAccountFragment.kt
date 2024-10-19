package com.moraga.ecoguardian

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.moraga.ecoguardian.databinding.FragmentCreateAccountBinding
import androidx.navigation.fragment.findNavController

class CreateAccountFragment : Fragment() {

    private var _binding: FragmentCreateAccountBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout using ViewBinding
        _binding = FragmentCreateAccountBinding.inflate(inflater, container, false)

        // Configurar el botón para navegar al siguiente fragmento
        binding.btnCrear.setOnClickListener {
            // Mostrar el Toast que dice "Cuenta creada"
            Toast.makeText(requireContext(), "Cuenta creada", Toast.LENGTH_SHORT).show()
            // Navegar al siguiente fragmento
            findNavController().navigate(R.id.action_createAccountFragment_to_mainEcosystemFragment)
        }

        return binding.root
    }
}
