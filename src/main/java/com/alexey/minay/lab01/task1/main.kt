package com.alexey.minay.lab01.task1

import com.alexey.minay.lab01.task1.di.MainComponent
import com.alexey.minay.lab01.task1.domain.TextSplitReplacer

private lateinit var textReplacer: TextSplitReplacer

fun main(args: Array<String>) {
    val argss = mutableListOf<String>()
    argss.add("/home/user/IdeaProjects/lab1file/test")
    argss.add("/home/user/IdeaProjects/lab1file/replace")
    argss.add("can")
    argss.add("123123123")
    val service = MainComponent.getReplaceService()
    service.replace(argss.toTypedArray())
}
