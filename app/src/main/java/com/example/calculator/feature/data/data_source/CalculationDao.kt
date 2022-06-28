package com.example.calculator.feature.data.data_source

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.calculator.feature.domain.model.CalculationInfo

@Dao
interface CalculationDao {

    @Query("SELECT * FROM calculation_info_table")
    fun getAllCalculationInfo(): LiveData<List<CalculationInfo>>
}