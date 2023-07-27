package com.jamshedalamqaderi.ktransport.plugin

import org.gradle.api.provider.Property

interface KTransportPluginExtension {
    val packageName: Property<String>
}