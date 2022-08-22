package com.example.calculator.feature.presentation.ui.calculation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.calculator.feature.domain.model.CalculationContent
import com.example.calculator.feature.domain.use_case.model.UseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class CalculationViewModel @Inject constructor(
    private val useCase: UseCase
): ViewModel() {

    private val _getAllCalculationContent = MutableLiveData<List<CalculationContent>>()
    val getAllCalculationContent : LiveData<List<CalculationContent>> = _getAllCalculationContent

    fun insertCalculationContentUseCase(calculationContent: CalculationContent) = viewModelScope.launch(Dispatchers.IO) {
        useCase.insertCalculationContentUseCase(calculationContent = calculationContent)
    }

    fun updateCalculationContentUseCase(calculationContent: CalculationContent) = viewModelScope.launch(Dispatchers.IO) {
        useCase.updateCalculationContentUseCase(calculationContent = calculationContent)
    }

    fun deleteCalculationContentUseCase(calculationContent: CalculationContent) = viewModelScope.launch(Dispatchers.IO) {
        useCase.deleteCalculationContentUseCase(calculationContent = calculationContent)
    }
}