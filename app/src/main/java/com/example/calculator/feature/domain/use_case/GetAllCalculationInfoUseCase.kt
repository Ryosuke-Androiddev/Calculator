package com.example.calculator.feature.domain.use_case

import androidx.lifecycle.LiveData
import com.example.calculator.feature.domain.model.CalculationInfoItem
import com.example.calculator.feature.domain.repository.CalculationRepository
import javax.inject.Inject

class GetAllCalculationInfoUseCase @Inject constructor(
    private val repository: CalculationRepository
) {

    operator fun invoke(): LiveData<List<CalculationInfoItem>> {

        return repository.getAllCalculationInfo()
    }
}