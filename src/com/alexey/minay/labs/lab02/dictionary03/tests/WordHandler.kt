package com.alexey.minay.labs.lab02.dictionary03.tests

class WordHandler(
        private val output: (value: String) -> Unit,
        private val input: () -> String?
) {

    val newWords = mutableMapOf<String, String>()

    fun handle(inputWord: String?, dictionary: Map<String, String>) {
        var translate = dictionary[inputWord]
        if (translate.isNullOrBlank()) {
            translate = newWords[inputWord]
            if (translate.isNullOrBlank()) {
                startAddCase(inputWord)
                return
            }
        }
        output.invoke("Перевод: $translate ")
    }

    private fun startAddCase(inputWord: String?) {
        output.invoke("Слово не найдено, введите перевод: ")
        val translate = input.invoke()
        if (translate.isNullOrBlank()) {
            output.invoke("Слово проигнорированно.")
        } else {
            if (inputWord != null) newWords[inputWord] = translate
            output.invoke("Слово $inputWord сохранено в словаре как: $translate.")
        }
    }
}