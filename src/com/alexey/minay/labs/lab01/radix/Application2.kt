package com.alexey.minay.labs.lab01.radix

import com.alexey.minay.labs.lab01.radix.radix.RadixChangerImpl
import com.alexey.minay.labs.lab01.radix.radix.RadixChangerResult
import com.alexey.minay.labs.lab01.radix.validator.ArgsValidatorImpl
import com.alexey.minay.labs.lab01.radix.validator.Messages
import com.alexey.minay.labs.lab01.radix.view.ConsoleView

class Application2 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            if (args.size != 3) {
                print(Messages.INCORRECT_ARGS_QUANTITY)
                return
            }
            Application2().change(
                    oldRadix = args[0],
                    newRadix = args[1],
                    value = args[2]
            )
        }
    }

    private val view = ConsoleView()
    private val validator = ArgsValidatorImpl()
    private val numbers: List<Char> = listOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E',
            'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z')
    private val radixChanger = RadixChangerImpl(validator, numbers)

    fun change(oldRadix: String, newRadix: String, value: String) {
        when (val result = radixChanger.change(oldRadix, newRadix, value)) {
            is RadixChangerResult.Success -> view.showResult(result.value)
            is RadixChangerResult.IncorrectNewRadix -> view.showResult(Messages.INCORRECT_NEW_RADIX)
            is RadixChangerResult.IncorrectOldRadix -> view.showResult(Messages.INCORRECT_OLD_RADIX)
            is RadixChangerResult.IncorrectValue -> view.showResult(Messages.INCORRECT_VALUE)
        }
    }

    fun error(message: String) {
        view.showResult(message)
    }
}

