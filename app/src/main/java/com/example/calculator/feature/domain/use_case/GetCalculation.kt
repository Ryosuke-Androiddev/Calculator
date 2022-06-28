package com.example.calculator.feature.domain.use_case

import androidx.lifecycle.LiveData
import com.example.calculator.feature.domain.model.Calculation
import com.example.calculator.feature.domain.repository.CalculationRepository
import javax.inject.Inject

class GetCalculation @Inject constructor(
    private val repository: CalculationRepository
) {

    operator fun invoke(): LiveData<Calculation> {
        return repository.getCalculation()
    }
}