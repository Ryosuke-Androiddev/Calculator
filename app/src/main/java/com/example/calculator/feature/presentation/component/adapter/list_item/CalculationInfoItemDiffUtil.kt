package com.example.calculator.feature.presentation.component.adapter.list_item

import androidx.recyclerview.widget.DiffUtil
import com.example.calculator.feature.domain.model.CalculationInfoItem

object CalculationInfoItemDiffUtil {

    val DIFF_UTIL = object : DiffUtil.ItemCallback<CalculationInfoItem>() {

        override fun areItemsTheSame(
            oldItem: CalculationInfoItem,
            newItem: CalculationInfoItem
        ): Boolean {

            // check the original property
            return oldItem.calculationId == newItem.calculationId
        }

        override fun areContentsTheSame(
            oldItem: CalculationInfoItem,
            newItem: CalculationInfoItem
        ): Boolean {

            // check the object
            return oldItem == newItem
        }
    }
}