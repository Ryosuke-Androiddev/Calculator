package com.example.calculator.feature.domain.use_case.model.calculation_info

import com.example.calculator.feature.domain.model.CalculationInfo
import com.example.calculator.feature.domain.repository.CalculationRepository

class InsertCalculationInfoUseCase(
    private val repository: CalculationRepository
) {
    suspend operator fun invoke(calculationInfo: CalculationInfo) {
        repository.insertCalculationInfo(calculationInfo = calculationInfo)
    }
}