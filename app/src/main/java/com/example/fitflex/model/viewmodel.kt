package com.example.fitflex.model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class FlexFitView : ViewModel() {

    private val _selectedColumn = mutableStateOf(1)
    val selectedColumn: MutableState<Int> get() = _selectedColumn

    private val _isStrengthButtonEnabled = mutableStateOf(true)
    val isStrengthButtonEnabled: MutableState<Boolean> get() = _isStrengthButtonEnabled

    private val _isEnduranceButtonEnabled = mutableStateOf(false)
    val isEnduranceButtonEnabled: MutableState<Boolean> get() = _isEnduranceButtonEnabled


    fun onStrengthButtonClicked() {
        _selectedColumn.value = 1
        _isStrengthButtonEnabled.value = true
        _isEnduranceButtonEnabled.value = false
    }

    fun onEnduranceButtonClicked() {
        _selectedColumn.value = 2
        _isStrengthButtonEnabled.value = false
        _isEnduranceButtonEnabled.value = true
    }
}



class ToggleCountViewModel : ViewModel() {
    private val _checkedButtonsCount = mutableStateOf(0)
    val checkedButtonsCount: State<Int> = _checkedButtonsCount


    fun updateCheckedButtonsCount(count: Int) {
        _checkedButtonsCount.value = count

    }
}
