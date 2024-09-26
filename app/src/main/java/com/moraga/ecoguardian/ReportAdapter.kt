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

    inner class ReportViewHolder(val binding: ItemReportBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(report: Report) {
            binding.tvUser.text = report.userName
            binding.tvLocation.text = report.location
            binding.tvTime.text = report.timeAgo
            binding.tvDescription.text = report.description
            binding.imgReport.setImageResource(report.imageRes)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReportViewHolder {
        val binding = ItemReportBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ReportViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ReportViewHolder, position: Int) {
        holder.bind(reportList[position])
    }

    override fun getItemCount(): Int = reportList.size
}