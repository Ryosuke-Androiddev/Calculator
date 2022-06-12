package com.example.calculator.feature.data.repository

import androidx.lifecycle.LiveData
import com.example.calculator.feature.data.data_source.CalculationDao
import com.example.calculator.feature.domain.model.CalculationInfoItem
import com.example.calculator.feature.domain.repository.CalculationRepository

class CalculationRepositoryImpl(
    private val calculationDao: CalculationDao
): CalculationRepository{

    override fun getAllCalculationInfo(): LiveData<List<CalculationInfoItem>> {

        return calculationDao.getAllCalculationInfo()
    }
}