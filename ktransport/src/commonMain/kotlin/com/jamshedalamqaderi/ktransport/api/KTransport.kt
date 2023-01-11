package com.jamshedalamqaderi.ktransport.api

object KTransport{
    fun setConfig(address:String, port:Int, usePlainText:Boolean = true){
        KTransportClientConfig.set(address, port, usePlainText)
    }
}