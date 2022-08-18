package com.example.calculator.feature.presentation.ui.calculation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.calculator.feature.domain.model.CalculationContent
import com.example.calculator.feature.domain.use_case.model.UseCase
import javax.inject.Inject

class CalculationViewModel @Inject constructor(
    private val useCase: UseCase
) {

    private val _getAllCalculationContent = MutableLiveData<List<CalculationContent>>()
    val getAllCalculationContent : LiveData<List<CalculationContent>> = _getAllCalculationContent
}