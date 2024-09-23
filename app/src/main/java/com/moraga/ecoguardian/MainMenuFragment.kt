package com.moraga.ecoguardian

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.moraga.ecoguardian.databinding.FragmentCreateAccountBinding
import com.moraga.ecoguardian.databinding.FragmentMainMenuBinding


class MainMenuFragment : Fragment() {
    private lateinit var binding: FragmentMainMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainMenuBinding.inflate(inflater, container, false)

        binding.btnCreateAccount.setOnClickListener {
            findNavController().navigate(R.id.action_mainMenuFragment_to_createAccountFragment)
        }

        binding.btnLogin.setOnClickListener {
            findNavController().navigate(R.id.action_mainMenuFragment_to_loginFragment)
        }
        return binding.root
    }

}