package com.example.calculator.feature.presentation.component.adapter.list_item

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.calculator.databinding.LayoutCalculationInfoItemBinding
import com.example.calculator.feature.domain.model.CalculationInfo
import com.example.calculator.feature.presentation.component.adapter.list_item.CalculationInfoItemDiffUtil.DIFF_UTIL

class CalculationInfoItemAdapter: ListAdapter<CalculationInfo, CalculationInfoItemViewHolder>(DIFF_UTIL) {

    private lateinit var listener: OnCalculationItemClickListener

    interface OnCalculationItemClickListener {
        fun onCalculationItemInfoOnClick(calculationInfo: CalculationInfo)
        fun showPopUpWindow(calculationInfo: CalculationInfo)
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

        calculationInfoItemViewHolder.showPopUpWindow(getItem(position)) { calculationInfoItem ->
            listener.showPopUpWindow(calculationInfoItem)
        }

        calculationInfoItemViewHolder.itemView.setOnClickListener {

            listener.onCalculationItemInfoOnClick(getItem(position))
        }
    }
}