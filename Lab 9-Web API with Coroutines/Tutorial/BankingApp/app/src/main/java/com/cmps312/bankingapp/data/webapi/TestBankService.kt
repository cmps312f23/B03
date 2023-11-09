package com.cmps312.bankingapp.data.webapi

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


suspend fun main() {
    val bankService = QuBankService()
    val job = CoroutineScope(Dispatchers.IO).launch {
        val transfers = bankService.getTransfers(10001)
        println(Json { prettyPrint = true }.encodeToString(transfers))
    }
    job.join()
    println("Done")

}
