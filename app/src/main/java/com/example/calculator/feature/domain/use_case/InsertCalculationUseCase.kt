package com.example.calculator.feature.domain.use_case

import com.example.calculator.feature.domain.model.CalculationContent
import com.example.calculator.feature.domain.repository.CalculationRepository
import javax.inject.Inject

class InsertCalculationUseCase @Inject constructor(
    private val repository: CalculationRepository
) {

    suspend operator fun invoke(calculationContent: CalculationContent) {
        repository.insertCalculation(calculationContent = calculationContent)
    }
}