package com.example.calculator.feature.data.repository

import androidx.lifecycle.LiveData
import com.example.calculator.feature.data.data_source.CalculationDao
import com.example.calculator.feature.domain.model.Calculation
import com.example.calculator.feature.domain.model.CalculationContent
import com.example.calculator.feature.domain.model.CalculationInfo
import com.example.calculator.feature.domain.repository.CalculationRepository

class CalculationRepositoryImpl(
    private val calculationDao: CalculationDao
): CalculationRepository{

    // CalculationInfo
    override suspend fun getAllCalculationInfo(): List<CalculationInfo> {
        return calculationDao.getAllCalculationInfo()
    }

    override suspend fun insertCalculationInfo(calculationInfo: CalculationInfo) {
       calculationDao.insertCalculationInfo(calculationInfo = calculationInfo)
    }

    override suspend fun updateCalculationInfo(calculationInfo: CalculationInfo) {
        updateCalculationInfo(calculationInfo = calculationInfo)
    }

    override suspend fun deleteCalculationInfo(calculationInfo: CalculationInfo) {
        deleteCalculationInfo(calculationInfo = calculationInfo)
    }

    override suspend fun searchCalculationInfo(searchQuery: String): List<CalculationInfo> {
        return calculationDao.searchCalculationInfo(searchQuery = searchQuery)
    }

    override suspend fun sortByDate(): List<CalculationInfo> {
        return calculationDao.sortByDate()
    }

    override suspend fun sortByName(): List<CalculationInfo> {
        return calculationDao.sortByName()
    }

    override fun getAllCalculationContent(): LiveData<List<CalculationContent>> {
        return calculationDao.getAllCalculationContent()
    }

    // Calculation Content
    override suspend fun insertCalculationContent(calculationContent: CalculationContent) {
        calculationDao.insertCalculation(calculationContent = calculationContent)
    }

    override suspend fun updateCalculationContent(calculationContent: CalculationContent) {
        calculationDao.updateCalculationContent(calculationContent = calculationContent)
    }

    override suspend fun deleteCalculationContent(calculationContent: CalculationContent) {
        calculationDao.deleteCalculationContent(calculationContent = calculationContent)
    }

    // Calculation
    override fun getCalculation(): LiveData<Calculation> {
        return calculationDao.getCalculation()
    }
}