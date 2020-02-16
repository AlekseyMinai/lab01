package domain

interface TextService {
    fun get(): String
    fun save(text: String)
}