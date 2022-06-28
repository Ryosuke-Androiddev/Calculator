package com.example.calculator.feature.domain.model

import androidx.room.Embedded
import androidx.room.Relation

data class Calculation(
    @Embedded val calculationContent: CalculationContent,
    @Relation(
        parentColumn = "contentId",
        entityColumn = "calculationContentId"
    )
    val calculationInfo: CalculationInfo
)
