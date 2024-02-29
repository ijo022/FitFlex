package com.example.fitflex.util

import androidx.compose.runtime.mutableStateOf



/**
 * Object for counting exercises and sets
 */

object ToggleCount {
    val checkedSets = mutableSetOf<Int>()
    val checkedButtonsCount = mutableStateOf(0)

    val completeSet = mutableStateOf(false)
    val completeSetNumber = mutableStateOf(0)

    fun isSetToggled(setNumber: Int): Boolean {
        return setNumber in checkedSets
    }

    fun toggleSet(setNumber: Int) {
        if (checkedSets.contains(setNumber)) {
            checkedSets.remove(setNumber)
        } else {
            checkedSets.add(setNumber)
        }
        updateCheckedButtons()
    }

    fun unToggleSet(setNumber: Int) {
        checkedSets.remove(setNumber)
        updateCheckedButtons()
    }

    fun getCheckedButtonsCount(): Int {
        return checkedButtonsCount.value
    }

    fun isCompleteExercise(): Boolean {
        return completeSet.value
    }

    fun getCompleteSetNumber(): Int {
        return completeSetNumber.value
    }

    fun updateCheckedButtons() {
        checkedButtonsCount.value = checkedSets.size
        updateCompleteSet()
    }


    fun updateCompleteSet() {
        val expectedButtonsCount = 4
        completeSet.value = checkedButtonsCount.value >= expectedButtonsCount
        if (completeSet.value) {
            completeSetNumber.value++
        }

    }
}




