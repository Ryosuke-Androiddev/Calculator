package com.example.calculator.feature.domain.repository

import androidx.lifecycle.LiveData
import com.example.calculator.feature.domain.model.CalculationInfoItem

interface CalculationRepository {

    fun getAllCalculationInfo(): LiveData<List<CalculationInfoItem>>
}