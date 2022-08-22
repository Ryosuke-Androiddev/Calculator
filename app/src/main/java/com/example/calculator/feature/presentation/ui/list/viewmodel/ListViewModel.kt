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

    init {
        getAllCalculationUseCase()
    }

    private val _getAllCalculation = MutableLiveData<List<CalculationInfo>>()
    val getAllCalculation: LiveData<List<CalculationInfo>> = _getAllCalculation

    // Calculation
    val getAllCalculationUseCase: LiveData<Calculation> = useCase.getCalculation()

    private fun getAllCalculationUseCase() = viewModelScope.launch(Dispatchers.IO) {
        _getAllCalculation.postValue(useCase.getAllCalculationInfoUseCase())
    }

    fun searchCalculationInfoUseCase(searchQuery: String) = viewModelScope.launch(Dispatchers.IO) {
        // 個々のロジックがうまくいってないからクラッシュしてる
        // DBに値を入れていないときは多分確認できないので代わりの処理で代行する
        _getAllCalculation.postValue(DummyData.list.filter { it.title == searchQuery })
        // _getAllCalculation.postValue(useCase.searchCalculationInfoUseCase(searchQuery = searchQuery))
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

    fun sortByDate() = viewModelScope.launch(Dispatchers.IO) {
        _getAllCalculation.postValue(useCase.sortByDateUseCase())
    }

    fun sortByName() = viewModelScope.launch(Dispatchers.IO) {
        _getAllCalculation.postValue(useCase.sortByNameUseCase())
    }
}