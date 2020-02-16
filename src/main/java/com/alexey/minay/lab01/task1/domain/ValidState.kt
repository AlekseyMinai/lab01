package com.alexey.minay.lab01.task1.domain

sealed class ValidState {
    object Valid: ValidState()
    class Invalid(message: String): ValidState()
}