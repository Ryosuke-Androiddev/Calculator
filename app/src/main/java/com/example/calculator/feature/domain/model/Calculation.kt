package com.example.calculator.feature.domain.model

import androidx.room.Embedded
import androidx.room.Relation

data class Calculation(
    @Embedded val calculationInfo: CalculationInfo,
    @Relation(
        parentColumn = "calculationId",
        entityColumn = "calculationInfoId"
    )
    val calculationContent: List<CalculationContent>
)
