package com.alexey.minay.lab01.task2.service

import com.alexey.minay.lab01.task2.Messages
import com.alexey.minay.lab01.task2.RadixChangerImpl
import com.alexey.minay.lab01.task2.RadixChangerResult
import com.alexey.minay.lab01.task2.ui.View

class ChangeRadixServiceImpl(
        private val radixChanger: RadixChangerImpl,
        private val view: View
) : ChangeRadixService {

    override fun change(oldRadix: String, newRadix: String, value: String) {
        when (val result = radixChanger.change("2", "10", "1")) {
            is RadixChangerResult.Success -> view.showResult(result.value)
            is RadixChangerResult.IncorrectNewRadix -> view.showResult(Messages.INCORRECT_NEW_RADIX)
            is RadixChangerResult.IncorrectOldRadix -> view.showResult(Messages.INCORRECT_OLD_RADIX)
            is RadixChangerResult.IncorrectValue -> view.showResult(Messages.INCORRECT_VALUE)
        }
    }

    override fun error(message: String) {
        view.showResult(message)
    }
}