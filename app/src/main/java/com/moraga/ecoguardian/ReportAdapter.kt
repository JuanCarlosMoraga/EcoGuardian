package com.moraga.ecoguardian

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.moraga.ecoguardian.databinding.ItemReportBinding

class Report (
    val userName: String,
    val location: String,
    val timeAgo: String,
    val description: String,
    val imageRes: Int
)

class ReportAdapter(private val reportList: List<Report>) : RecyclerView.Adapter<ReportAdapter.ReportViewHolder>() {

    /**
     * ViewHolder para mostrar un único elemento de reporte.
     *
     * @property binding El objeto de enlace para el diseño del elemento de reporte.
     */
    inner class ReportViewHolder(val binding: ItemReportBinding) : RecyclerView.ViewHolder(binding.root) {
        /**
         * Vincula los datos del reporte a las vistas en el ViewHolder.
         *
         * @param report El objeto Report que contiene los datos a mostrar.
         */
        fun bind(report: Report) {
            binding.tvUser.text = report.userName
            binding.tvLocation.text = report.location
            binding.tvTime.text = report.timeAgo
            binding.tvDescription.text = report.description
            binding.imgReport.setImageResource(report.imageRes)
        }
    }


     //Crea un nuevo ViewHolder para los elementos de reporte.

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReportViewHolder {
        val binding = ItemReportBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ReportViewHolder(binding)
    }
    //Vincula los datos del reporte al ViewHolder especificado.
    override fun onBindViewHolder(holder: ReportViewHolder, position: Int) {
        holder.bind(reportList[position])
    }
    //Retorna el número total de reportes en la lista.
    override fun getItemCount(): Int = reportList.size
}