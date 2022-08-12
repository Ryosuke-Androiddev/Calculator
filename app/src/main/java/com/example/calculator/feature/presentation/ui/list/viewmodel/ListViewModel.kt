package com.example.calculator.feature.presentation.ui.list.viewmodel

import androidx.lifecycle.*
import com.example.calculator.feature.domain.model.Calculation
import com.example.calculator.feature.domain.model.CalculationContent
import com.example.calculator.feature.domain.model.CalculationInfo
import com.example.calculator.feature.domain.use_case.model.UseCase
import com.example.calculator.feature.presentation.util.DummyData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val useCase: UseCase
): ViewModel() {

    //val getAllCalculation: LiveData<List<CalculationInfoItem>> = useCase.getAllCalculationInfoUseCase()

    private val list = DummyData.list
    private val _getAllCalculation: MutableLiveData<List<CalculationInfo>> = MutableLiveData(list)
    val getAllCalculationInfoUseCase: LiveData<List<CalculationInfo>> = _getAllCalculation

    // val getAllCalculation: LiveData<List<CalculationInfo>> = useCase.getAllCalculationInfoUseCase()
    val sortByDate: LiveData<List<CalculationInfo>> = useCase.sortByDateUseCase()
    val sortByName: LiveData<List<CalculationInfo>> = useCase.sortByNameUseCase()

    // Calculation
    val getAllCalculationUseCase: LiveData<Calculation> = useCase.getCalculation()

    // Search, Sort
    private val _searchResult: MutableLiveData<List<CalculationInfo>> = MutableLiveData()
    val searchResult: LiveData<List<CalculationInfo>> = _searchResult

    fun getAllCalculationInfoUseCase() : LiveData<List<CalculationInfo>> {
        return useCase.getAllCalculationInfoUseCase()
    }

    fun insertCalculationInfoUseCase(calculationInfo: CalculationInfo) = viewModelScope.launch {
        useCase.insertCalculationInfoUseCase(calculationInfo = calculationInfo)
    }

    fun updateCalculationInfoUseCase(calculationInfo: CalculationInfo) = viewModelScope.launch {
        useCase.updateCalculationInfoUseCase(calculationInfo = calculationInfo)
    }

    fun deleteCalculationInfoUseCase(calculationInfo: CalculationInfo) = viewModelScope.launch {
        useCase.deleteCalculationInfoUseCase(calculationInfo = calculationInfo)
    }

    fun insertCalculationContentUseCase(calculationContent: CalculationContent) = viewModelScope.launch {
        useCase.insertCalculationContentUseCase(calculationContent = calculationContent)
    }

    fun updateCalculationContentUseCase(calculationContent: CalculationContent) = viewModelScope.launch {
        useCase.updateCalculationContentUseCase(calculationContent = calculationContent)
    }

    fun deleteCalculationContentUseCase(calculationContent: CalculationContent) = viewModelScope.launch {
        useCase.deleteCalculationContentUseCase(calculationContent = calculationContent)
    }
}