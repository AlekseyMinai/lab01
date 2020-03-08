package com.alexey.minay.lab01.task2

import com.alexey.minay.lab01.task2.di.MainComponent
import com.alexey.minay.lab01.task2.validator.Messages

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

