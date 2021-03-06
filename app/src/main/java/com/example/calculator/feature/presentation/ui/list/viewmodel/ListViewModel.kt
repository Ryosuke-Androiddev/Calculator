package com.example.calculator.feature.presentation.ui.list.viewmodel

import androidx.lifecycle.*
import com.example.calculator.feature.domain.model.CalculationInfo
import com.example.calculator.feature.domain.use_case.model.UseCase
import com.example.calculator.feature.presentation.util.DummyData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val useCase: UseCase
): ViewModel() {

    //val getAllCalculation: LiveData<List<CalculationInfoItem>> = useCase.getAllCalculationInfoUseCase()

    private val list = DummyData.list
    private val _getAllCalculation: LiveData<List<CalculationInfo>> = MutableLiveData(list)
    val getAllCalculation: LiveData<List<CalculationInfo>> = _getAllCalculation

}