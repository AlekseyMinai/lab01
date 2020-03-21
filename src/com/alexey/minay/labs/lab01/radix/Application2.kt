package com.alexey.minay.labs.lab01.radix

import com.alexey.minay.labs.lab01.radix.di.MainComponent
import com.alexey.minay.labs.lab01.radix.validator.Messages

class Application2 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val radixService = MainComponent.getRadixService()
            if (args.size != 3) {
                radixService.error(Messages.INCORRECT_ARGS_QUANTITY)
                return
            }
            radixService.change(
                    oldRadix = args[0],
                    newRadix = args[1],
                    value = args[2]
            )
        }
    }
}

