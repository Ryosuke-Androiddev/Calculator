package com.example.calculator.feature.domain.repository

import androidx.lifecycle.LiveData
import com.example.calculator.feature.domain.model.Calculation
import com.example.calculator.feature.domain.model.CalculationContent
import com.example.calculator.feature.domain.model.CalculationInfo

interface CalculationRepository {

    // CalculationInfo
    fun getAllCalculationInfo(): LiveData<List<CalculationInfo>>

    // Calculation
    fun getCalculation(): LiveData<Calculation>

    // Insert
    suspend fun insertCalculation(calculationContent: CalculationContent)
    // Update, Delete, Search, Date Sort → 対応するdata class ごとに実装して、UseCaseを作成する
}