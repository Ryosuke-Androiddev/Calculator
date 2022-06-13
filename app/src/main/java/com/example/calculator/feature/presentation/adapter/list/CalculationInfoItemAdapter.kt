package com.example.calculator.feature.presentation.adapter.list

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.calculator.feature.domain.model.CalculationInfoItem
import com.example.calculator.feature.presentation.adapter.list.CalculationInfoItemDiffUtil.DIFF_UTIL

class CalculationInfoItemAdapter: ListAdapter<CalculationInfoItem, CalculationInfoItemViewHolder>(DIFF_UTIL) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CalculationInfoItemViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: CalculationInfoItemViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}