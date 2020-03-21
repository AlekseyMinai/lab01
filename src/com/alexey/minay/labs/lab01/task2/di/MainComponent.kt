package com.alexey.minay.labs.lab01.task2.di

import com.alexey.minay.labs.lab01.task2.radix.RadixChangerImpl
import com.alexey.minay.labs.lab01.task2.service.ChangeRadixServiceImpl
import com.alexey.minay.labs.lab01.task2.view.ConsoleView
import com.alexey.minay.labs.lab01.task2.validator.ArgsValidatorImpl

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