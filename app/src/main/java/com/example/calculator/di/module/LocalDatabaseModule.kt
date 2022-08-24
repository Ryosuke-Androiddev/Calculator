package com.example.calculator.di.module

import android.app.Application
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.calculator.feature.data.data_source.CalculationDatabase
import com.example.calculator.feature.data.repository.CalculationRepositoryImpl
import com.example.calculator.feature.data.util.DataLayerConstants.CALCULATION_DATABASE_NAME
import com.example.calculator.feature.domain.repository.CalculationRepository
import com.example.calculator.feature.domain.use_case.model.calculation.GetCalculationUseCase
import com.example.calculator.feature.domain.use_case.model.calculation_content.InsertCalculationContentUseCase
import com.example.calculator.feature.domain.use_case.model.UseCase
import com.example.calculator.feature.domain.use_case.model.calculation_content.DeleteCalculationContentUseCase
import com.example.calculator.feature.domain.use_case.model.calculation_content.GetAllCalculationContentUseCase
import com.example.calculator.feature.domain.use_case.model.calculation_content.UpdateCalculationContentUseCase
import com.example.calculator.feature.domain.use_case.model.calculation_info.*
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
        ).addMigrations(MIGRATION_1_2).build()
    }

    private val MIGRATION_1_2 = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
            // 新しいテーブルを作成
            database.execSQL("CREATE TABLE IF NOT EXISTS 'calculation_content_table_new' " +
                    "('contentId' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                    "'answer' TEXT NOT NULL, " +
                    "'formulaProcess' TEXT NOT NULL, " +
                    "'calculationInfoId' INTEGER NOT NULL)"
            )
            // Tableの削除
            database.execSQL("DROP TABLE IF EXISTS calculation_content_table")
            database.execSQL("ALTER TABLE calculation_content_table_new RENAME TO calculation_content_table")
        }
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
            insertCalculationInfoUseCase = InsertCalculationInfoUseCase(repository = calculationRepository),
            updateCalculationInfoUseCase = UpdateCalculationInfoUseCase(repository = calculationRepository),
            deleteCalculationInfoUseCase = DeleteCalculationInfoUseCase(repository = calculationRepository),
            searchCalculationInfoUseCase = SearchCalculationInfoUseCase(repository = calculationRepository),
            sortByDateUseCase = SortByDateUseCase(repository = calculationRepository),
            sortByNameUseCase = SortByNameUseCase(repository = calculationRepository),
            getAllCalculationContentUseCase = GetAllCalculationContentUseCase(repository = calculationRepository),
            insertCalculationContentUseCase = InsertCalculationContentUseCase(repository = calculationRepository),
            updateCalculationContentUseCase = UpdateCalculationContentUseCase(repository = calculationRepository),
            deleteCalculationContentUseCase = DeleteCalculationContentUseCase(repository = calculationRepository),
            getCalculation = GetCalculationUseCase(repository = calculationRepository)
        )
    }
}