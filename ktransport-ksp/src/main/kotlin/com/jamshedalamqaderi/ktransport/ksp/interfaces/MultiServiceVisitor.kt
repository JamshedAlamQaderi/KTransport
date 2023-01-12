package com.jamshedalamqaderi.ktransport.ksp.interfaces

import com.google.devtools.ksp.symbol.KSVisitorVoid

abstract class MultiServiceVisitor : KSVisitorVoid() {
    abstract fun commit()
}
