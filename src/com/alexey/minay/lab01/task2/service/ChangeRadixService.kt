package com.alexey.minay.lab01.task2.service

interface ChangeRadixService {
    fun change(oldRadix: String, newRadix: String, value: String)
    fun error(message: String)
}