package com.alexey.minay.labs.lab01.replace.domain

sealed class ValidationState {
    object Valid : ValidationState()
    class Invalid(val message: String) : ValidationState()
}