package com.example.calculator.feature.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.calculator.feature.domain.model.CalculationContent
import com.example.calculator.feature.domain.model.CalculationInfo

@Database(
    entities = [CalculationInfo::class, CalculationContent::class],
    version = 1,
    exportSchema = false
)
abstract class CalculationDatabase: RoomDatabase() {

    abstract fun calculationDao(): CalculationDao
}