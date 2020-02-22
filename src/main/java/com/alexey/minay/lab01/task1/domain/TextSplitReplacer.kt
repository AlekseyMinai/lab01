package com.alexey.minay.lab01.task1.domain

class TextSplitReplacer: TextReplacer {

    private var search: String? = null
    private var replace: String? = null

    override fun setParams(search: String, replace: String){
        this.search = search
        this.replace = replace
    }

    override fun replace(oldText: String): String {
        if(isNotSetParams()){
            return oldText
        }
        val listSplitSearch = search?.let { oldText.split(it) }
        val newText = StringBuilder()
        listSplitSearch?.forEachIndexed { index, part ->
            newText.append(part)
            if (isNeedToIncludeReplaceText(listSplitSearch, index)) {
                newText.append(replace)
            }
        }
        return newText.toString()
    }

    private fun isNotSetParams() = search.isNullOrEmpty() || replace.isNullOrEmpty()

    private fun isNeedToIncludeReplaceText(listSplitSearch: List<String>, index: Int) =
            listSplitSearch.size - 1 != index

}