package com.example.calculator.feature.domain.use_case.model.calculation_content

import androidx.lifecycle.LiveData
import com.example.calculator.feature.domain.model.CalculationContent
import com.example.calculator.feature.domain.repository.CalculationRepository
import javax.inject.Inject

class GetAllCalculationContentUseCase @Inject constructor(
    private val repository: CalculationRepository
) {

    operator fun invoke() : LiveData<List<CalculationContent>> {
        return repository.getAllCalculationContent()
    }
}