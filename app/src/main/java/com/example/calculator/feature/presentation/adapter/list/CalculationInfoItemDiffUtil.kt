package com.example.calculator.feature.presentation.adapter.list

import androidx.recyclerview.widget.DiffUtil
import com.example.calculator.feature.domain.model.CalculationInfoItem

object CalculationInfoItemDiffUtil {

    val DIFF_UTIL = object : DiffUtil.ItemCallback<CalculationInfoItem>() {

        override fun areItemsTheSame(
            oldItem: CalculationInfoItem,
            newItem: CalculationInfoItem
        ): Boolean {
            TODO("Not yet implemented")
        }

        override fun areContentsTheSame(
            oldItem: CalculationInfoItem,
            newItem: CalculationInfoItem
        ): Boolean {
            TODO("Not yet implemented")
        }
    }
}