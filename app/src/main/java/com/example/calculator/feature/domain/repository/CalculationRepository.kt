package com.example.calculator.feature.domain.repository

import androidx.lifecycle.LiveData
import com.example.calculator.feature.domain.model.Calculation
import com.example.calculator.feature.domain.model.CalculationContent
import com.example.calculator.feature.domain.model.CalculationInfo

interface CalculationRepository {

    // model CalculationInfo

    // Get
    fun getAllCalculationInfo(): LiveData<List<CalculationInfo>>
    // Insert
    suspend fun insertCalculationInfo(calculationInfo: CalculationInfo)
    // Update
    suspend fun updateCalculationInfo(calculationInfo: CalculationInfo)
    // Delete
    suspend fun deleteCalculationInfo(calculationInfo: CalculationInfo)
    // Search
    suspend fun searchCalculationInfo(searchQuery: String): LiveData<List<CalculationInfo>>
    // Date Sort
    suspend fun sortByDate(): LiveData<List<CalculationInfo>>
    // Name Sort
    suspend fun sortByName(): LiveData<List<CalculationInfo>>

    // model CalculationContent

    // Insert
    suspend fun insertCalculationContent(calculationContent: CalculationContent)
    // Update
    suspend fun updateCalculationContent(calculationContent: CalculationContent)
    // Delete
    suspend fun deleteCalculationContent(calculationContent: CalculationContent)

    // model Calculation

    // Get
    fun getCalculation(): LiveData<Calculation>
}