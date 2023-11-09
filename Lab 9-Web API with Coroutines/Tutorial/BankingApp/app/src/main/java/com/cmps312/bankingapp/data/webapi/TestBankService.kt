package cmps312.bankingapp.webapi

import com.cmps312.bankingapp.data.model.Transfer
import com.cmps312.bankingapp.data.webapi.QuBankService
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collectLatest
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
