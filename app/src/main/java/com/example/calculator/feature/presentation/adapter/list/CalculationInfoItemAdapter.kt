package com.example.calculator.feature.presentation.adapter.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.calculator.databinding.LayoutCalculationInfoItemBinding
import com.example.calculator.feature.domain.model.CalculationInfoItem
import com.example.calculator.feature.presentation.adapter.list.CalculationInfoItemDiffUtil.DIFF_UTIL

class CalculationInfoItemAdapter: ListAdapter<CalculationInfoItem, CalculationInfoItemViewHolder>(DIFF_UTIL) {

    private lateinit var listener: OnCalculationItemClickListener

    interface OnCalculationItemClickListener {
        fun onCalculationItemInfoOnClick(calculationInfoItem: CalculationInfoItem)
    }

    fun setOnCalculationClickListener(listener: OnCalculationItemClickListener) {
        this.listener = listener
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CalculationInfoItemViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = LayoutCalculationInfoItemBinding.inflate(layoutInflater, parent, false)

        return CalculationInfoItemViewHolder(binding)
    }

    override fun onBindViewHolder(calculationInfoItemViewHolder: CalculationInfoItemViewHolder, position: Int) {

        calculationInfoItemViewHolder.bind(getItem(position))

        calculationInfoItemViewHolder.itemView.setOnClickListener {

            listener.onCalculationItemInfoOnClick(getItem(position))
        }
    }
}