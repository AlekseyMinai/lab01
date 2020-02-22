package com.alexey.minay.lab01.task1

import com.alexey.minay.lab01.task1.di.MainComponent
import com.alexey.minay.lab01.task1.domain.TextSplitReplacer

private lateinit var textReplacer: TextSplitReplacer

fun main(args: Array<String>) {
    val service = MainComponent.getReplaceService()
    service.replace(args)
}
