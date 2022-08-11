package com.example.calculator.feature.domain.use_case.model

import com.example.calculator.feature.domain.use_case.model.calculation_info.GetAllCalculationInfoUseCase
import com.example.calculator.feature.domain.use_case.model.calculation.GetCalculationUseCase
import com.example.calculator.feature.domain.use_case.model.calculation_content.DeleteCalculationContentUseCase
import com.example.calculator.feature.domain.use_case.model.calculation_content.InsertCalculationContentUseCase
import com.example.calculator.feature.domain.use_case.model.calculation_content.UpdateCalculationContentUseCase

data class UseCase(
    val getAllCalculationInfoUseCase: GetAllCalculationInfoUseCase,
    val insertCalculationContentUseCase: InsertCalculationContentUseCase,
    val updateCalculationContentUseCase: UpdateCalculationContentUseCase,
    val deleteCalculationContentUseCase: DeleteCalculationContentUseCase,
    val getCalculation: GetCalculationUseCase
)
