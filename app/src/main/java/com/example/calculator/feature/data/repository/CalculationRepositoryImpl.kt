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
    override fun getAllCalculationInfo(): LiveData<List<CalculationInfo>> {

        return calculationDao.getAllCalculationInfo()
    }

    override suspend fun insertCalculationInfo(calculationInfo: CalculationInfo) {
        return calculationDao.insertCalculationInfo(calculationInfo = calculationInfo)
    }

    override suspend fun updateCalculationInfo(calculationInfo: CalculationInfo) {
        return updateCalculationInfo(calculationInfo = calculationInfo)
    }

    override suspend fun deleteCalculationInfo(calculationInfo: CalculationInfo) {
        return deleteCalculationInfo(calculationInfo = calculationInfo)
    }

    override fun searchCalculationInfo(searchQuery: String): LiveData<List<CalculationInfo>> {
        return calculationDao.searchCalculationInfo(searchQuery = searchQuery)
    }

    override fun sortByDate(): LiveData<List<CalculationInfo>> {
        return calculationDao.sortByDate()
    }

    override fun sortByName(): LiveData<List<CalculationInfo>> {
        return calculationDao.sortByName()
    }

    // Calculation Content
    override suspend fun insertCalculationContent(calculationContent: CalculationContent) {
        return calculationDao.insertCalculation(calculationContent = calculationContent)
    }

    override suspend fun updateCalculationContent(calculationContent: CalculationContent) {
        return calculationDao.updateCalculationContent(calculationContent = calculationContent)
    }

    override suspend fun deleteCalculationContent(calculationContent: CalculationContent) {
        return calculationDao.deleteCalculationContent(calculationContent = calculationContent)
    }

    // Calculation
    override fun getCalculation(): LiveData<Calculation> {
        return calculationDao.getCalculation()
    }
}