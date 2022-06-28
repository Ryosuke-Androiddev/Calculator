package com.example.calculator.feature.domain.use_case.model

import com.example.calculator.feature.domain.use_case.GetAllCalculationInfoUseCase
import com.example.calculator.feature.domain.use_case.GetCalculation

data class UseCase(
    val getAllCalculationInfoUseCase: GetAllCalculationInfoUseCase,
    val getCalculation: GetCalculation
)
