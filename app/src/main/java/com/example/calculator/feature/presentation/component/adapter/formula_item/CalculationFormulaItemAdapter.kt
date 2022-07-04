package com.example.calculator.feature.presentation.component.adapter.formula_item

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.calculator.databinding.LayoutCalculationFormulaItemBinding
import com.example.calculator.feature.domain.model.CalculationContent
import com.example.calculator.feature.presentation.component.adapter.formula_item.CalculationFormulaItemDiffUtil.DIFF_UTIL

class CalculationFormulaItemAdapter: ListAdapter<CalculationContent, CalculationFormulaItemViewHolder>(DIFF_UTIL) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CalculationFormulaItemViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = LayoutCalculationFormulaItemBinding.inflate(layoutInflater, parent, false)

        return CalculationFormulaItemViewHolder(binding)
    }

    override fun onBindViewHolder(calculationFormulaItemViewHolder: CalculationFormulaItemViewHolder, position: Int) {

        calculationFormulaItemViewHolder.bind(getItem(position))
    }
}