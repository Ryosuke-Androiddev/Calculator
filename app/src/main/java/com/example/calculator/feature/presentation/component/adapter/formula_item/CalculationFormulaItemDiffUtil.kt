package com.example.calculator.feature.presentation.component.adapter.formula_item

import androidx.recyclerview.widget.DiffUtil
import com.example.calculator.feature.domain.model.CalculationContent

object CalculationFormulaItemDiffUtil {

    val DIFF_UTIL = object : DiffUtil.ItemCallback<CalculationContent>() {

        override fun areItemsTheSame(
            oldItem: CalculationContent,
            newItem: CalculationContent
        ): Boolean {
            return oldItem.contentId == newItem.contentId
        }

        override fun areContentsTheSame(
            oldItem: CalculationContent,
            newItem: CalculationContent
        ): Boolean {
            return oldItem == newItem
        }

    }
}