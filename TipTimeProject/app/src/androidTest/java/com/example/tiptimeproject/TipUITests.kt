package com.example.tiptimeproject

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.tiptimeproject.ui.theme.TipTimeProjectTheme
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.text.NumberFormat

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class TipUITests {


    @get :Rule
    val composeTestRule = createComposeRule()

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.tiptimeproject", appContext.packageName)
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Test
    fun calculate20Tip() {
        composeTestRule.setContent {
            TipTimeProjectTheme {
                TipTimeLayout()
            }
                composeTestRule.onNodeWithText("Bill Amount").performTextInput("10")
                composeTestRule.onNodeWithText("Tip Percentage").performTextInput("20")

            val expectedTip = NumberFormat.getCurrencyInstance().format(2)
            composeTestRule.onNodeWithText("Tip Amount : $expectedTip").assertExists("No such Field Exists")
        }
    }
}