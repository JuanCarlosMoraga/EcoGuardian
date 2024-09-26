package com.moraga.ecoguardian

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.moraga.ecoguardian.databinding.FragmentLoginBinding
import com.moraga.ecoguardian.databinding.FragmentMainMenuBinding


class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)

        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            if (validateCredentials(username, password)) {
                findNavController().navigate(R.id.action_loginFragment_to_mainEcosystemFragment)
            } else {
                binding.etUsername.error = "Usuario o contraseña incorrectos"
                binding.etPassword.error = "Usuario o contraseña incorrectos"
            }
        }

        return binding.root
    }

    private fun validateCredentials(username: String, password: String): Boolean {
        // Credenciales de usuario
        return username == "admin" && password == "1234"
    }
}