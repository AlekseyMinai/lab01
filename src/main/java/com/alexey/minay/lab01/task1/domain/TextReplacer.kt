package com.alexey.minay.lab01.task1.domain

class TextReplacer(
        private var search: String,
        private var replace: String
) {

    fun replace(oldText: String): String {
        val listSplitSearch = oldText.split(search)
        val newText = StringBuilder()
        listSplitSearch.forEachIndexed { index, part ->
            newText.append(part)
            if (isNeedToIncludeReplaceText(listSplitSearch, index)) {
                newText.append(replace)
            }
        }
        return newText.toString()
    }

    private fun isNeedToIncludeReplaceText(listSplitSearch: List<String>, index: Int) =
            listSplitSearch.size - 1 != index

}