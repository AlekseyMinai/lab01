package com.alexey.minay.labs.lab01.radix

import com.alexey.minay.labs.lab01.radix.radix.RadixChangerImpl
import com.alexey.minay.labs.lab01.radix.radix.RadixChangerResult
import com.alexey.minay.labs.lab01.radix.validator.ArgsValidatorImpl
import com.alexey.minay.labs.lab01.radix.validator.Messages
import com.alexey.minay.labs.lab01.radix.view.ConsoleView

fun main(args: Array<String>) {
    if (args.size != 3) {
        print(Messages.INCORRECT_ARGS_QUANTITY)
        return
    }
    change(
            oldRadix = args[0],
            newRadix = args[1],
            value = args[2]
    )
}

fun change(oldRadix: String, newRadix: String, value: String) {
    val view = ConsoleView()
    val validator = ArgsValidatorImpl()
    val numbers: List<Char> = listOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E',
            'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z')
    val radixChanger = RadixChangerImpl(validator, numbers)
    when (val result = radixChanger.change(oldRadix, newRadix, value)) {
        is RadixChangerResult.Success -> view.showResult(result.value)
        is RadixChangerResult.IncorrectNewRadix -> view.showResult(Messages.INCORRECT_NEW_RADIX)
        is RadixChangerResult.IncorrectOldRadix -> view.showResult(Messages.INCORRECT_OLD_RADIX)
        is RadixChangerResult.IncorrectValue -> view.showResult(Messages.INCORRECT_VALUE)
        is RadixChangerResult.TooBigValue -> view.showResult(Messages.INCORRECT_VALUE)
    }
}


