package com.alexey.minay.lab01.task1

import com.alexey.minay.lab01.task1.domain.TextSplitReplacer
import com.alexey.minay.lab01.task1.storage.FileTextReader

private lateinit var textReplacer: TextSplitReplacer

fun main(args: Array<String>) {
    ///home/user/IdeaProjects/lab1file/test
    FileTextReader().read("/home/user/IdeaProjects/lab1file/test") { println(it) }
//    val service = MainComponent.getReplaceService()
//    service.replace(args)
}
