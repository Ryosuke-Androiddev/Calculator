package com.example.calculator.feature.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.calculator.feature.data.util.DataLayerConstants.CALCULATION_INFO_TABLE_NAME

@Entity(tableName = CALCULATION_INFO_TABLE_NAME)
data class CalculationInfoItem(
    @PrimaryKey(autoGenerate = true)
    val calculationId: Long,
    val title: String,
    val date: Long
)
