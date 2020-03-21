package com.alexey.minay.labs.lab01.radix.service

import com.alexey.minay.labs.lab01.radix.radix.RadixChangerImpl
import com.alexey.minay.labs.lab01.radix.radix.RadixChangerResult
import com.alexey.minay.labs.lab01.radix.view.View
import com.alexey.minay.labs.lab01.radix.validator.Messages

class ChangeRadixServiceImpl(
        private val radixChanger: RadixChangerImpl,
        private val view: View
) : ChangeRadixService {

    override fun change(oldRadix: String, newRadix: String, value: String) {
        val result = radixChanger.change(oldRadix, newRadix, value)
        when (result) {
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