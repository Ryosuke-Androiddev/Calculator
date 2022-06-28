package com.example.calculator.feature.domain.repository

import androidx.lifecycle.LiveData
import com.example.calculator.feature.domain.model.CalculationInfo

interface CalculationRepository {

    fun getAllCalculationInfo(): LiveData<List<CalculationInfo>>
}