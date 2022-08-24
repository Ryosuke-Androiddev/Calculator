package com.example.calculator.feature.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.calculator.feature.data.data_source.type_converter.DateConverters
import com.example.calculator.feature.domain.model.CalculationContent
import com.example.calculator.feature.domain.model.CalculationInfo

@Database(
    entities = [CalculationInfo::class, CalculationContent::class],
    version = 2,
    exportSchema = false
)
@TypeConverters(DateConverters::class)
abstract class CalculationDatabase: RoomDatabase() {

    abstract fun calculationDao(): CalculationDao
}