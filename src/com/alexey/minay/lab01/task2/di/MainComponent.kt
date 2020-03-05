package com.alexey.minay.lab01.task2.di

import com.alexey.minay.lab01.task2.RadixChangerImpl
import com.alexey.minay.lab01.task2.service.ChangeRadixServiceImpl
import com.alexey.minay.lab01.task2.ui.ConsoleView
import com.alexey.minay.lab01.task2.validator.ArgsValidatorImpl

object MainComponent {
    fun getRadixService(): ChangeRadixServiceImpl {
        val view = ConsoleView()
        val validator = ArgsValidatorImpl()
        val changer = RadixChangerImpl(validator)
        return ChangeRadixServiceImpl(
                view = view,
                radixChanger = changer
        )
    }
}