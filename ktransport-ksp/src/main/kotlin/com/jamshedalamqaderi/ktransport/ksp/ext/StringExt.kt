package com.jamshedalamqaderi.ktransport.ksp.ext

object StringExt {
    fun String.toCamelCase(): String {
        return this[0].lowercaseChar() + this.substring(1 until this.length)
    }
}
