package com.example.calculator.feature.data.data_source

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.example.calculator.feature.domain.model.Calculation
import com.example.calculator.feature.domain.model.CalculationInfo

@Dao
interface CalculationDao {

    // CalculationInfo
    @Query("SELECT * FROM calculation_info_table")
    fun getAllCalculationInfo(): LiveData<List<CalculationInfo>>

    // Calculation

    @Transaction
    @Query("SELECT * FROM calculation_content_table")
    fun getCalculation(): LiveData<Calculation>
}