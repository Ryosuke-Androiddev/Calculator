package com.example.calculator.feature.domain.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.calculator.feature.data.util.DataLayerConstants.CALCULATION_INFO_TABLE_NAME
import kotlinx.parcelize.Parcelize

@Entity(tableName = CALCULATION_INFO_TABLE_NAME)
@Parcelize
data class CalculationInfoItem(
    @PrimaryKey(autoGenerate = true)
    val calculationId: Long,
    val title: String,
    val date: Long
): Parcelable
