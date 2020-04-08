package com.alexey.minay.labs.lab02.template06

import org.junit.Assert.assertEquals
import org.junit.Test


class ApplicationKtTest {

    @Test
    fun shouldReplaceParamsInTemplate1() {
        val template = "-AABBCCCCCABC+"
        val params = mutableMapOf(Pair("A", "[a]"),
                Pair("AA", "[aa]"), Pair("B", "[b]"), Pair("BB", "[bb]"), Pair("C", "[c]"), Pair("CC", "[cc]"))

        val expandResult = expandTemplate(template, params)
        assertEquals("-[aa][bb][cc][cc][c][a][b][c]+", expandResult)
    }

    @Test
    fun shouldReplaceParamsInTemplate2() {
        val template = "Hello, %USER_NAME%. Today is {WEEK_DAY}."
        val params = mutableMapOf(Pair("%USER_NAME%", "Super %USER_NAME% {WEEK_DAY}"), Pair("{WEEK_DAY}", "Friday. {WEEK_DAY}"))

        val expandResult = expandTemplate(template, params)
        assertEquals("Hello, Super %USER_NAME% {WEEK_DAY}. Today is Friday. {WEEK_DAY}.", expandResult)
    }


    @Test
    fun shouldReplaceParamsInTemplate3() {
        val template = "Hello, %USER_NAME%. Today is {WEEK_DAY}."
        val params = mutableMapOf(Pair("%USER_NAME%", "Ivan Petrov"), Pair("{WEEK_DAY}", "Friday"))

        val expandResult = expandTemplate(template, params)
        assertEquals("Hello, Ivan Petrov. Today is Friday.", expandResult)
    }

    @Test
    fun shouldReplaceParamsInTemplate4() {
        val template = "-[aa][bb][cc][cc][c][a][b][c]+"
        val params = mutableMapOf(Pair("[a]", "A"), Pair("[aa]", "AA"), Pair("[b]", "B"),
                Pair("[bb]", "BB"), Pair("[c]", "C"), Pair("[cc]", "CC"))

        val expandResult = expandTemplate(template, params)
        assertEquals("-AABBCCCCCABC+", expandResult)
    }

}