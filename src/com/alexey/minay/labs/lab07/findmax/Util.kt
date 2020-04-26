package com.alexey.minay.labs.lab07.findmax

fun <T : Comparable<T>> findMax(list: List<T>, maxValueSetter: (T) -> Unit): Boolean {
    if (list.isNullOrEmpty()) return false
    var maxValue: T = list[0]
    list.forEach { if (it > maxValue) maxValue = it }
    maxValueSetter.invoke(maxValue)
    return true
}

