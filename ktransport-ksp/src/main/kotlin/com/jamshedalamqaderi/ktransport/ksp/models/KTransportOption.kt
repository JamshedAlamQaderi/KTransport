package com.jamshedalamqaderi.ktransport.ksp.models

data class KTransportOption(val packageName: String) {
    constructor(options: Map<String, String>) : this(options["packageName"] ?: "ktransport")
}