package com.example.calculator.feature.presentation.ui.list.viewmodel

import androidx.lifecycle.*
import com.example.calculator.feature.domain.model.Calculation
import com.example.calculator.feature.domain.model.CalculationContent
import com.example.calculator.feature.domain.model.CalculationInfo
import com.example.calculator.feature.domain.use_case.model.UseCase
import com.example.calculator.feature.presentation.util.DummyData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val useCase: UseCase
): ViewModel() {
    // Calculation
    val getAllCalculationUseCase: LiveData<Calculation> = useCase.getCalculation()

    // Calculation Info LiveData
    val getAllCalculationInfoUseCase: LiveData<List<CalculationInfo>> = useCase.getAllCalculationInfoUseCase()
    val sortByDate: LiveData<List<CalculationInfo>> = useCase.sortByDateUseCase()
    val sortByName: LiveData<List<CalculationInfo>> = useCase.sortByNameUseCase()

    fun searchCalculationInfoUseCase(searchQuery: String): LiveData<List<CalculationInfo>> {
        return useCase.searchCalculationInfoUseCase(searchQuery = searchQuery)
    }

    fun insertCalculationInfoUseCase(calculationInfo: CalculationInfo) = viewModelScope.launch(Dispatchers.IO) {
        useCase.insertCalculationInfoUseCase(calculationInfo = calculationInfo)
    }

    fun updateCalculationInfoUseCase(calculationInfo: CalculationInfo) = viewModelScope.launch(Dispatchers.IO) {
        useCase.updateCalculationInfoUseCase(calculationInfo = calculationInfo)
    }

    fun deleteCalculationInfoUseCase(calculationInfo: CalculationInfo) = viewModelScope.launch(Dispatchers.IO) {
        useCase.deleteCalculationInfoUseCase(calculationInfo = calculationInfo)
    }
}