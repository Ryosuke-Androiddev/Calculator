package com.example.calculator.feature.domain.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.calculator.feature.domain.util.DomainLayerConstants.CALCULATION_INFO_TABLE_NAME
import kotlinx.parcelize.Parcelize
import java.util.*

@Entity(tableName = CALCULATION_INFO_TABLE_NAME)
@Parcelize
data class CalculationInfo(
    @PrimaryKey(autoGenerate = true)
    val calculationId: Long,
    val title: String,
    val date: Date
): Parcelable
