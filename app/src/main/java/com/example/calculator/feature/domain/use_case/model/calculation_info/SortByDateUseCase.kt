package com.example.calculator.feature.domain.use_case.model.calculation_info

import androidx.lifecycle.LiveData
import com.example.calculator.feature.domain.model.CalculationInfo
import com.example.calculator.feature.domain.repository.CalculationRepository

class SortByDateUseCase(
    private val repository: CalculationRepository
) {
    operator fun invoke() : LiveData<List<CalculationInfo>> {
        return repository.sortByDate()
    }
}