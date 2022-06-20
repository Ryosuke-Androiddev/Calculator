package com.example.calculator.feature.presentation.component.adapter.list_item

import android.util.Log
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

    fun showPopUpWindow(calculationInfoItem: CalculationInfoItem, popUpWindow: (calculationInfoItem: CalculationInfoItem) -> Unit) {

        binding.popUpImageButton.setOnClickListener {
            Log.d("PopUpImageButton", "PopUpImageButton Clicked")
            popUpWindow(calculationInfoItem)
        }
    }
}