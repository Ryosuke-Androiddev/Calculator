package com.example.calculator.feature.presentation.ui.make.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.calculator.feature.domain.model.CalculationContent
import com.example.calculator.feature.domain.use_case.model.UseCase
import javax.inject.Inject

class MakeNewCalculationViewModel @Inject constructor(
    private val useCase: UseCase
): ViewModel() {

    private val _getAllCalculationContent = MutableLiveData<List<CalculationContent>>()
    val getAllCalculationContent : LiveData<List<CalculationContent>> = _getAllCalculationContent
}