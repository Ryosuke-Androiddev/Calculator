package com.example.calculator.feature.data.data_source

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.calculator.feature.domain.model.Calculation
import com.example.calculator.feature.domain.model.CalculationContent
import com.example.calculator.feature.domain.model.CalculationInfo

@Dao
interface CalculationDao {

    // CalculationInfo
    @Query("SELECT * FROM calculation_info_table")
    suspend fun getAllCalculationInfo(): List<CalculationInfo>

    // Insert
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCalculationInfo(calculationInfo: CalculationInfo)
    // Update
    @Update
    suspend fun updateCalculationInfo(calculationInfo: CalculationInfo)
    // Delete
    @Delete
    suspend fun deleteCalculationInfo(calculationInfo: CalculationInfo)
    // Search
    // "SELECT * FROM url_memo_entity WHERE title LIKE "%検索キーワード%"
    @Query("SELECT * FROM calculation_info_table WHERE title LIKE :searchQuery")
    fun searchCalculationInfo(searchQuery: String): List<CalculationInfo>
    // Date Sort
    @Query("SELECT * FROM calculation_info_table ORDER BY date ASC")
    fun sortByDate(): List<CalculationInfo>
    // Name Sort
    @Query("SELECT * FROM calculation_info_table ORDER BY title DESC")
    fun sortByName(): List<CalculationInfo>

    // Calculation Content
    @Query("SELECT * FROM calculation_content_table")
    fun getAllCalculationContent(): LiveData<List<CalculationContent>>
    // Insert
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCalculation(calculationContent: CalculationContent)
    // Update
    @Update
    suspend fun updateCalculationContent(calculationContent: CalculationContent)
    // Delete
    @Delete
    suspend fun deleteCalculationContent(calculationContent: CalculationContent)

    // Calculation
    @Transaction
    @Query("SELECT * FROM calculation_info_table")
    fun getCalculation(): LiveData<Calculation>
}