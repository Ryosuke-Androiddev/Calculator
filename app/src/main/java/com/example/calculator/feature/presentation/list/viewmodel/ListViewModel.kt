package com.example.calculator.feature.presentation.list.viewmodel

import androidx.lifecycle.*
import com.example.calculator.feature.domain.model.CalculationInfoItem
import com.example.calculator.feature.domain.use_case.model.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val useCase: UseCase
): ViewModel() {

    val getAllCalculation: LiveData<List<CalculationInfoItem>> = useCase.getAllCalculationInfoUseCase()
}