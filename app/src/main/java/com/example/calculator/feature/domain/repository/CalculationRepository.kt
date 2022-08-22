package com.example.calculator.feature.domain.repository

import androidx.lifecycle.LiveData
import com.example.calculator.feature.domain.model.Calculation
import com.example.calculator.feature.domain.model.CalculationContent
import com.example.calculator.feature.domain.model.CalculationInfo

interface CalculationRepository {

    // model CalculationInfo

    // Get
    suspend fun getAllCalculationInfo(): List<CalculationInfo>
    // Insert
    suspend fun insertCalculationInfo(calculationInfo: CalculationInfo)
    // Update
    suspend fun updateCalculationInfo(calculationInfo: CalculationInfo)
    // Delete
    suspend fun deleteCalculationInfo(calculationInfo: CalculationInfo)
    // Search
    suspend fun searchCalculationInfo(searchQuery: String): List<CalculationInfo>
    // Date Sort
    suspend fun sortByDate(): List<CalculationInfo>
    // Name Sort
    suspend fun sortByName(): List<CalculationInfo>

    // model CalculationContent

    // Get
    fun getAllCalculationContent(): LiveData<List<CalculationContent>>
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