package com.example.fitflex

import com.example.fitflex.model.FlexFitView
import org.junit.Assert.assertTrue
import org.junit.Test



/**
 * Unit test to check if strength button is enabled upon startup
 */
class StrengthEnabledTest {

    @Test
    fun strengthEnabledAtStart() {

        val viewModel = FlexFitView()

        // When
        val isStrengthButtonEnabled = viewModel.isStrengthButtonEnabled.value

        // Then
        assertTrue(isStrengthButtonEnabled)
    }
}