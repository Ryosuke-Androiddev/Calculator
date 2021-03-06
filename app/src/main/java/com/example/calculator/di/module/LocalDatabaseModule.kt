package com.example.calculator.di.module

import android.app.Application
import androidx.room.Room
import com.example.calculator.feature.data.data_source.CalculationDatabase
import com.example.calculator.feature.data.repository.CalculationRepositoryImpl
import com.example.calculator.feature.data.util.DataLayerConstants.CALCULATION_DATABASE_NAME
import com.example.calculator.feature.domain.repository.CalculationRepository
import com.example.calculator.feature.domain.use_case.GetAllCalculationInfoUseCase
import com.example.calculator.feature.domain.use_case.GetCalculationUseCase
import com.example.calculator.feature.domain.use_case.model.UseCase
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

    @Provides
    @Singleton
    fun provideCalculationRepository(calculationDatabase: CalculationDatabase): CalculationRepository {

        return CalculationRepositoryImpl(calculationDatabase.calculationDao())
    }

    @Provides
    @Singleton
    fun provideUseCase(calculationRepository: CalculationRepository): UseCase {
        return UseCase(
            getAllCalculationInfoUseCase = GetAllCalculationInfoUseCase(repository = calculationRepository),
            getCalculation = GetCalculationUseCase(repository = calculationRepository)
        )
    }
}