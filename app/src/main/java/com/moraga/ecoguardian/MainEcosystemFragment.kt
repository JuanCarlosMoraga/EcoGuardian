package com.moraga.ecoguardian

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.moraga.ecoguardian.databinding.FragmentMainEcosystemBinding

class MainEcosystemFragment : Fragment() {

    // Declarar el binding
    private lateinit var binding: FragmentMainEcosystemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Notificar que este fragmento tiene un menú
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar el layout usando ViewBinding
        binding = FragmentMainEcosystemBinding.inflate(inflater, container, false)

        // Configurar el toolbar como ActionBar
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)

        // Configurar la toolbar para retroceder
        binding.toolbar.setNavigationOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed() // Vuelve a la pantalla anterior
        }

        // Cargar imagen de la flora y fauna
        binding.imgFloraFauna.setImageResource(R.drawable.flora_y_fauna_de_nicaragua_3347_orig) // Cambia por la imagen correcta

        // Simular carga de datos (puede provenir de una base de datos o de una API)
        binding.tvFloraTitle.text = "Flora"
        binding.tvFloraDesc.text =
            "La flora en esta región es muy diversa, incluyendo especies como el roble, la ceiba, y numerosas flores exóticas."

        binding.tvFaunaTitle.text = "Fauna"
        binding.tvFaunaDesc.text =
            "La fauna local es rica en especies, destacándose el jaguar, el venado cola blanca, y una variedad de aves tropicales."

        return binding.root // Retorna la vista inflada
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_ecoguardian, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.maps -> {
                findNavController().navigate(R.id.action_mainEcosystemFragment_to_mapFragment2) // Navegar a MapsFragment
                true
            }

            R.id.report -> {
                findNavController().navigate(R.id.action_mainEcosystemFragment_to_reportFragment) // Navegar a ReportFragment
                true
            }

            R.id.comment -> {
                findNavController().navigate(R.id.action_mainEcosystemFragment_to_commentFragment2) // Navegar a CommentFragment
                true
            }

            R.id.notifications -> {
                findNavController().navigate(R.id.action_mainEcosystemFragment_to_notificationsFragment) // Navegar a NotificationsFragment
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}