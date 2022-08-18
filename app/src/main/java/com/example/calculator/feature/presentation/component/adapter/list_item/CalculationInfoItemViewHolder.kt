package com.example.calculator.feature.presentation.component.adapter.list_item

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.calculator.databinding.LayoutCalculationInfoItemBinding
import com.example.calculator.feature.domain.model.CalculationInfo
import java.text.SimpleDateFormat
import java.util.*

class CalculationInfoItemViewHolder(
    private val binding: LayoutCalculationInfoItemBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(calculationInfo: CalculationInfo) {

        binding.titleTextView.text = calculationInfo.title
        binding.creationDateTextView.text = calculationInfo.date.toString()

        val simpleDateFormat = SimpleDateFormat("yyyy/MM/dd(EEE)", Locale.JAPAN)
        // タイムゾーンを設定
        simpleDateFormat.timeZone = TimeZone.getTimeZone("Asia/Tokyo")

        binding.creationDateTextView.text = simpleDateFormat.format(calculationInfo.date)
    }

    fun showPopUpWindow(calculationInfo: CalculationInfo, popUpWindow: (calculationInfo: CalculationInfo) -> Unit) {

        binding.popUpImageButton.setOnClickListener {
            Log.d("PopUpImageButton", "PopUpImageButton Clicked")
            popUpWindow(calculationInfo)
        }
    }
}