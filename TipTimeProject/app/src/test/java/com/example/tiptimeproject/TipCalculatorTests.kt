package com.example.tiptimeproject

import org.junit.Test

import org.junit.Assert.*
import java.text.NumberFormat

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class TipCalculatorTests {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
    @Test
    fun calculateTip_20NoRoundUp(){

        val amount = 10.00;
        val percent = 20.00;
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        val actualTip =   calculateTip(roundUp = false , amount = amount , tipPercent =  percent)
        assertEquals(expectedTip , actualTip)

    }
}