package com.example.calculator.feature.data.repository

import androidx.lifecycle.LiveData
import com.example.calculator.feature.data.data_source.CalculationDao
import com.example.calculator.feature.domain.model.Calculation
import com.example.calculator.feature.domain.model.CalculationInfo
import com.example.calculator.feature.domain.repository.CalculationRepository

class CalculationRepositoryImpl(
    private val calculationDao: CalculationDao
): CalculationRepository{

    // CalculationInfo
    override fun getAllCalculationInfo(): LiveData<List<CalculationInfo>> {

        return calculationDao.getAllCalculationInfo()
    }

    // Calculation
    override fun getCalculation(): LiveData<Calculation> {
        return calculationDao.getCalculation()
    }
}