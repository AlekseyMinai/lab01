package com.alexey.minay.lab01.task1

import com.alexey.minay.lab01.task1.di.MainComponent
import com.alexey.minay.lab01.task1.domain.BufferTextReplacer

private lateinit var textReplacer: BufferTextReplacer

fun main(args: Array<String>) {
    val argss = mutableListOf<String>()
    argss.add("E:\\IdeaProjects\\labs2\\test\\text.txt")
    argss.add("E:\\IdeaProjects\\labs2\\test\\test.txt")
    argss.add("Skibidi")
    argss.add("Скибиди")
    val replaceService = MainComponent.getReplaceService()
    replaceService.replace(argss.toTypedArray())
}

