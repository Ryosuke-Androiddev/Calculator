package com.example.calculator.feature.domain.use_case

import androidx.lifecycle.LiveData
import com.example.calculator.feature.domain.model.CalculationInfo
import com.example.calculator.feature.domain.repository.CalculationRepository
import javax.inject.Inject

class GetAllCalculationInfoUseCase @Inject constructor(
    private val repository: CalculationRepository
) {

    operator fun invoke(): LiveData<List<CalculationInfo>> {

        return repository.getAllCalculationInfo()
    }
}