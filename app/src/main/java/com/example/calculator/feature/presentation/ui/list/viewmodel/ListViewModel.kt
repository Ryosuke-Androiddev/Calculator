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

    // ここLiveDataの使い方がちゃうかも
    private val _getAllCalculation: MutableLiveData<List<CalculationInfo>> = MutableLiveData(list)
    val getAllCalculationInfoUseCase: LiveData<List<CalculationInfo>> = _getAllCalculation

    // val getAllCalculation: LiveData<List<CalculationInfo>> = useCase.getAllCalculationInfoUseCase()
    // ここは、suspendに書き換えたあとに、スレッド指定して変更を通知する
    // メソッドで呼び出して変更を加える
    // val sortByDate: LiveData<List<CalculationInfo>> = useCase.sortByDateUseCase()
    // val sortByName: LiveData<List<CalculationInfo>> = useCase.sortByNameUseCase()

    // Calculation
    val getAllCalculationUseCase: LiveData<Calculation> = useCase.getCalculation()

    // Search, Sort
    // private val _searchResult = MutableLiveData<List<CalculationInfo>>()
    // val searchResult: LiveData<List<CalculationInfo>> = _searchResult

    fun searchCalculationInfoUseCase(searchQuery: String) = viewModelScope.launch {
        _getAllCalculation.postValue(useCase.searchCalculationInfoUseCase(searchQuery = searchQuery))
    }

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

    fun sortByDate() = viewModelScope.launch {
        _getAllCalculation.postValue(useCase.sortByDateUseCase())
    }

    fun sortByName() = viewModelScope.launch {
        _getAllCalculation.postValue(useCase.sortByNameUseCase())
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