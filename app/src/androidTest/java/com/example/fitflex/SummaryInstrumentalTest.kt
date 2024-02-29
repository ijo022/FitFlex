package com.example.fitflex

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.fitflex.util.ToggleCount
import org.hamcrest.CoreMatchers.`is`
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class SummaryInstrumentalTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun testClickingCheckBoxes() {
        // Start your activity
        composeTestRule.setContent {
            // Use your composable here, for example:
            Summary()
        }

        //onView(withId(R.id.checkbox1)).perform(click())
        //onView(withId(R.id.checkbox2)).perform(click())
        //onView(withId(R.id.checkbox3)).perform(click())
        //onView(withId(R.id.checkbox4)).perform(click())

        // Wait for UI to settle
        composeTestRule.waitForIdle()

        // Verify UI changes, e.g., check the updated text values in Summary composable

        // Get the updated value of checkedButtonsCount
        val updatedCheckedButtonsCount = ToggleCount.getCheckedButtonsCount()

        // Verify that the count matches the expected value (4 in this case)
        assertThat(updatedCheckedButtonsCount, `is`(4))
    }
}