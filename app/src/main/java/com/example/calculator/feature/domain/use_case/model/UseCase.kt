package com.example.calculator.feature.domain.use_case.model

import com.example.calculator.feature.domain.use_case.GetAllCalculationInfoUseCase
import com.example.calculator.feature.domain.use_case.GetCalculationUseCase
import com.example.calculator.feature.domain.use_case.InsertCalculationUseCase

data class UseCase(
    val getAllCalculationInfoUseCase: GetAllCalculationInfoUseCase,
    val getCalculation: GetCalculationUseCase,
    val insertCalculationUseCase: InsertCalculationUseCase
)
