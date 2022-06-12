package com.example.calculator.di.module

import android.app.Application
import androidx.room.Room
import com.example.calculator.feature.data.data_source.CalculationDatabase
import com.example.calculator.feature.data.util.DataLayerConstants.CALCULATION_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalDatabaseModule {

    @Provides
    @Singleton
    fun provideCalculationDatabase(application: Application): CalculationDatabase {

        return Room.databaseBuilder(
            application,
            CalculationDatabase::class.java,
            CALCULATION_DATABASE_NAME
        ).build()
    }

}