package com.example.calculator.feature.domain.use_case.model

import com.example.calculator.feature.domain.use_case.model.calculation.GetCalculationUseCase
import com.example.calculator.feature.domain.use_case.model.calculation_content.DeleteCalculationContentUseCase
import com.example.calculator.feature.domain.use_case.model.calculation_content.GetAllCalculationContentUseCase
import com.example.calculator.feature.domain.use_case.model.calculation_content.InsertCalculationContentUseCase
import com.example.calculator.feature.domain.use_case.model.calculation_content.UpdateCalculationContentUseCase
import com.example.calculator.feature.domain.use_case.model.calculation_info.*

data class UseCase(
    val getAllCalculationInfoUseCase: GetAllCalculationInfoUseCase,
    val insertCalculationInfoUseCase: InsertCalculationInfoUseCase,
    val updateCalculationInfoUseCase: UpdateCalculationInfoUseCase,
    val deleteCalculationInfoUseCase: DeleteCalculationInfoUseCase,
    val searchCalculationInfoUseCase: SearchCalculationInfoUseCase,
    val sortByDateUseCase: SortByDateUseCase,
    val sortByNameUseCase: SortByNameUseCase,
    val getAllCalculationContentUseCase: GetAllCalculationContentUseCase,
    val insertCalculationContentUseCase: InsertCalculationContentUseCase,
    val updateCalculationContentUseCase: UpdateCalculationContentUseCase,
    val deleteCalculationContentUseCase: DeleteCalculationContentUseCase,
    val getCalculation: GetCalculationUseCase
)
