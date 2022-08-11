package com.example.calculator.feature.domain.use_case.model

import com.example.calculator.feature.domain.use_case.model.calculation_info.GetAllCalculationInfoUseCase
import com.example.calculator.feature.domain.use_case.model.calculation.GetCalculationUseCase
import com.example.calculator.feature.domain.use_case.model.calculation_content.InsertCalculationContentUseCase

data class UseCase(
    val getAllCalculationInfoUseCase: GetAllCalculationInfoUseCase,
    val getCalculation: GetCalculationUseCase,
    val insertCalculationContentUseCase: InsertCalculationContentUseCase
)
