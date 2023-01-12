package com.jamshedalamqaderi.ktransport.ksp.ext

import com.google.devtools.ksp.symbol.KSTypeReference

object KSTypeReferenceExt {
    fun KSTypeReference.typeParamFormat(): String {
        return if (resolve().arguments.isEmpty()) {
            "${resolve().declaration.qualifiedName?.asString()}"
        } else {
            "${
            resolve().arguments.first()
                .type?.resolve()?.declaration?.qualifiedName?.asString()
            }"
        }
    }
}
