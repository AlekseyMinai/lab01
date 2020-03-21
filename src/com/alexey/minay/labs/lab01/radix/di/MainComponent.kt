package com.alexey.minay.labs.lab01.radix.di

import com.alexey.minay.labs.lab01.radix.radix.RadixChangerImpl
import com.alexey.minay.labs.lab01.radix.service.ChangeRadixServiceImpl
import com.alexey.minay.labs.lab01.radix.view.ConsoleView
import com.alexey.minay.labs.lab01.radix.validator.ArgsValidatorImpl

object MainComponent {
    fun getRadixService(): ChangeRadixServiceImpl {
        val view = ConsoleView()
        val validator = ArgsValidatorImpl()
        val numbers: List<Char> = listOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E',
                'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z')
        val changer = RadixChangerImpl(validator, numbers)
        return ChangeRadixServiceImpl(
                view = view,
                radixChanger = changer
        )
    }
}