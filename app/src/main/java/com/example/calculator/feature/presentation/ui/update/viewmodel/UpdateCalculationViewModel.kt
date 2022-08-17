package com.example.calculator.feature.presentation.ui.update.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.calculator.feature.domain.model.CalculationContent
import com.example.calculator.feature.domain.use_case.model.UseCase
import javax.inject.Inject

class UpdateCalculationViewModel @Inject constructor(
    private val useCase: UseCase
): ViewModel() {

    private val _getAllUpdateScreenCalculation = MutableLiveData<List<CalculationContent>>()
    val getAllUpdateScreenCalculationContent : LiveData<List<CalculationContent>> = _getAllUpdateScreenCalculation
}