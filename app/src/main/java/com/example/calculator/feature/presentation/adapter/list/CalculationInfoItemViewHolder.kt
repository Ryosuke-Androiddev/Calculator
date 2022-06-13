package com.example.calculator.feature.presentation.adapter.list

import androidx.recyclerview.widget.RecyclerView
import com.example.calculator.databinding.LayoutCalculationInfoItemBinding
import com.example.calculator.feature.domain.model.CalculationInfoItem

class CalculationInfoItemViewHolder(
    private val binding: LayoutCalculationInfoItemBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(calculationInfoItem: CalculationInfoItem) {

        binding.titleTextView.text = calculationInfoItem.title
        binding.creationDateTextView.text = calculationInfoItem.date.toString()
    }
}