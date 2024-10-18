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
        binding.Managua.setImageResource(R.drawable.logoinicio) //

        // Simular carga de datos (puede provenir de una base de datos o de una API)
        binding.tvFloraTitle.text = "Objetivo General"
        binding.tvFloraDesc.text =
            "Desarrollar una aplicación móvil que facilite la denuncia de botaderos ilegales de basura en Managua, promoviendo la participación ciudadana y mejorando la gestión de residuos sólidos por parte de la Alcaldía para contribuir a una ciudad más limpia, segura y sostenible."

        binding.tvFaunaTitle.text = "Objetivo Especifico"
        binding.tvFaunaDesc.text =
            "1.\tCrear un sistema interactivo de reportes que permita a los ciudadanos identificar y denunciar botaderos ilegales, incluyendo la ubicación GPS, fotos y descripciones detalladas.\n" +
                    "2.\tImplementar un panel de control para la Alcaldía que optimice la gestión y priorización de las acciones de limpieza, mediante herramientas de análisis y generación de informes.\n" +
                    "3.\tIntegrar la aplicación con redes sociales y una base de datos centralizada, fomentando la conciencia ciudadana sobre la problemática de los botaderos ilegales y facilitando el seguimiento de los reportes por parte de los usuarios."

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