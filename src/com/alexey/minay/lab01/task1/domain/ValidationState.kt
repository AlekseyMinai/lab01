package com.alexey.minay.lab01.task1.domain

sealed class ValidationState {
    object Valid : ValidationState()
    class Invalid(val message: String) : ValidationState()
}