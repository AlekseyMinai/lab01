package com.alexey.minay.lab01.task2.service

import com.alexey.minay.lab01.task2.RadixChangerImpl
import com.alexey.minay.lab01.task2.ui.View

class ChangeRadixServiceImpl(
        val radixChanger: RadixChangerImpl,
        val view: View
) : ChangeRadixService {

    override fun change(oldRadix: Int, newRadix: Int, value: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}