package com.alexey.minay.labs.lab02.parser05

fun main() {
    val url = "http://www.mysite.com/docs/document1.html?page=30&lang=en#title"

    var protocol: Protocol? = null
    var port: Int? = null
    var host: String? = null
    var document: String? = null

    val protocolRef: (Protocol) -> Unit = { protocol = it }
    val portRef: (Int) -> Unit = { port = it }
    val hostRef: (String) -> Unit = { host = it }
    val documentRef: (String) -> Unit = { document = it }

    if (parseUrl(url, protocolRef, portRef, hostRef, documentRef)) {
        println(url)
        println("HOST: $host")
        println("PORT: $port")
        println("DOC: $document")
    } else {
        print("Url \"$url\" is invalid")
    }
}

fun parseUrl(url: String,
             protocolRef: (Protocol) -> Unit,
             portRef: (Int) -> Unit,
             hostRef: (String) -> Unit,
             documentRef: (String) -> Unit
): Boolean {
    val urlRegex = """(https?|ftp)://((www.)?.+?\.[a-z0-9]{2,6})(:[0-9]{1,5})?(/)?(.*)?""".toRegex(RegexOption.IGNORE_CASE)
    if (!urlRegex.matches(url)) {
        return false
    }
    val splittedUrl = urlRegex.find(url)?.groupValues

    val protocol = splittedUrl?.get(1)?.toProtocol()
    if (protocol == null || protocol == Protocol.UNKNOWN) {
        return false
    }
    protocolRef.invoke(protocol)

    if (!parsePort(protocol, portRef, splittedUrl)) {
        return false
    }

    hostRef.invoke(splittedUrl[2])
    documentRef.invoke(splittedUrl[6])
    return true
}

fun parsePort(protocol: Protocol, portRef: (Int) -> Unit, splittedUrl: List<String>?): Boolean {
    var portStr = splittedUrl?.get(4)
    if (portStr.isNullOrBlank()) {
        portStr = when (protocol) {
            Protocol.FTP -> "21"
            Protocol.HTTPS -> "443"
            Protocol.HTTP -> "80"
            else -> "-1"
        }
    }
    return try {
        val port = portStr.removePrefix(":").toInt()
        if (port !in 1..65535) {
            return false
        }
        portRef.invoke(port)
        true
    } catch (e: Exception) {
        false
    }
}

fun String.toProtocol() =
        when (this.toLowerCase()) {
            "https" -> Protocol.HTTPS
            "http" -> Protocol.HTTP
            "ftp" -> Protocol.FTP
            else -> Protocol.UNKNOWN
        }

enum class Protocol {
    HTTP, HTTPS, FTP, UNKNOWN
}