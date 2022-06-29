package com.example.calculator.feature.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.calculator.feature.domain.util.DomainLayerConstants.CALCULATION_CONTENT_TABLE_NAME

@Entity(tableName = CALCULATION_CONTENT_TABLE_NAME)
data class CalculationContent(
    @PrimaryKey(autoGenerate = true)
    val contentId: Long,
    val answer: Long,
    val formulaProcess: List<String>
)
