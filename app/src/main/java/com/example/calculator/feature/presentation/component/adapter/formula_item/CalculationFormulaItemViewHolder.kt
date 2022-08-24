package com.example.calculator.feature.presentation.component.adapter.formula_item

import androidx.recyclerview.widget.RecyclerView
import com.example.calculator.databinding.LayoutCalculationFormulaItemBinding
import com.example.calculator.feature.domain.model.CalculationContent

class CalculationFormulaItemViewHolder(
    private val binding: LayoutCalculationFormulaItemBinding
): RecyclerView.ViewHolder(binding.root) {


    fun bind(calculationContent: CalculationContent) {
        binding.calculationFormula.text = calculationContent.formulaProcess
        binding.calculationAnswer.text = calculationContent.answer
    }
}