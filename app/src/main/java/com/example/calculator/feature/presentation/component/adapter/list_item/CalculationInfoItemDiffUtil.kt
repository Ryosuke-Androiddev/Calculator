package com.example.calculator.feature.presentation.component.adapter.list_item

import androidx.recyclerview.widget.DiffUtil
import com.example.calculator.feature.domain.model.CalculationInfo

object CalculationInfoItemDiffUtil {

    val DIFF_UTIL = object : DiffUtil.ItemCallback<CalculationInfo>() {

        override fun areItemsTheSame(
            oldItem: CalculationInfo,
            newItem: CalculationInfo
        ): Boolean {

            // check the original property
            return oldItem.calculationId == newItem.calculationId
        }

        override fun areContentsTheSame(
            oldItem: CalculationInfo,
            newItem: CalculationInfo
        ): Boolean {

            // check the object
            return oldItem == newItem
        }
    }
}