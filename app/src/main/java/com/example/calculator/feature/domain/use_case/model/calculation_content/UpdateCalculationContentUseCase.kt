package com.example.calculator.feature.domain.use_case.model.calculation_content

import com.example.calculator.feature.domain.model.CalculationContent
import com.example.calculator.feature.domain.repository.CalculationRepository
import com.example.calculator.feature.domain.use_case.model.UseCase
import javax.inject.Inject

class UpdateCalculationContentUseCase @Inject constructor(
    private val repository: CalculationRepository
) {
    suspend operator fun invoke(calculationContent: CalculationContent) {
        repository.updateCalculationContent(calculationContent = calculationContent)
    }
}