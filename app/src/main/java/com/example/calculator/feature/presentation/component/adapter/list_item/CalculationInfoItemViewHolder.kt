package com.example.calculator.feature.presentation.component.adapter.list_item

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.calculator.databinding.LayoutCalculationInfoItemBinding
import com.example.calculator.feature.domain.model.CalculationInfo

class CalculationInfoItemViewHolder(
    private val binding: LayoutCalculationInfoItemBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(calculationInfo: CalculationInfo) {

        binding.titleTextView.text = calculationInfo.title
        binding.creationDateTextView.text = calculationInfo.date.toString()
    }

    fun showPopUpWindow(calculationInfo: CalculationInfo, popUpWindow: (calculationInfo: CalculationInfo) -> Unit) {

        binding.popUpImageButton.setOnClickListener {
            Log.d("PopUpImageButton", "PopUpImageButton Clicked")
            popUpWindow(calculationInfo)
        }
    }
}