package com.moraga.ecoguardian

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.moraga.ecoguardian.databinding.FragmentReportBinding


class ReportFragment : Fragment() {

    private lateinit var binding: FragmentReportBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentReportBinding.inflate(inflater, container, false)

        // Configurar RecyclerView
        val reportList = listOf(
            Report("Ludafou MG", "Pueblos, Managua", "Hace 2 h", "Lorem ipsum dolor sit amet", R.drawable.basurero),
            Report("Ludafou MG", "Pueblos, Managua", "Hace 2 h", "Descripción del reporte 2", R.drawable.basurero)
        )

        binding.recyclerViewReports.layoutManager = LinearLayoutManager(context)
        binding.recyclerViewReports.adapter = ReportAdapter(reportList)

        // Botón de retroceso
        binding.toolbar.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }

        return binding.root
    }
}