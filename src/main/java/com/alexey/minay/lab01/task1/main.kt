package com.alexey.minay.lab01.task1

import com.alexey.minay.lab01.task1.di.MainComponent
import com.alexey.minay.lab01.task1.domain.BufferTextReplacer

private lateinit var textReplacer: BufferTextReplacer

fun main(args: Array<String>) {
    val replacer = BufferTextReplacer()
    replacer.setParams("ра", "!!!!!!!!!!!!!!!", ::print)
    val before = System.currentTimeMillis()

    //text.forEach { replacer.replace(it) }
    val argss = mutableListOf<String>()
    argss.add("E:\\IdeaProjects\\labs2\\test\\text.txt")
    argss.add("E:\\IdeaProjects\\labs2\\test\\test.txt")
    argss.add("an")
    argss.add("111111111")
    val replaceService = MainComponent.getReplaceService()
    replaceService.replace(argss.toTypedArray())


    replacer.finish()
    val after = System.currentTimeMillis()
    //print(after-before)
}

