package com.cmps312.bankingapp.repository.remote

import com.cmps312.bankingapp.model.Account
import com.cmps312.bankingapp.model.Beneficiary
import com.cmps312.bankingapp.model.Transfer
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.json.Json

//create a class that allows us to talk to the server
//CRUD [create read update and delete

class QuBankService : BankService {
    //    create the base url
    val baseUrl = "https://cmps312banking.cyclic.app/api"

    //    create the client
    private val client = HttpClient(OkHttp) {
        install(ContentNegotiation) {
            json(
                json = Json {
                    ignoreUnknownKeys = true
                    prettyPrint = true
                }
            )
        }

    }

    override fun getTransfers(cid: Int): Flow<List<Transfer>> = flow {
        val refreshDelayTime = 10000L
        val url = "$baseUrl/transfers/$cid"

        while(true){
            emit(client.get(url).body())
            delay(refreshDelayTime)
        }
    }

    override suspend fun addTransfer(transfer: Transfer): Transfer {
        val url = "$baseUrl/transfers/${transfer.cid}"
        return client.post(url) {
            setBody(transfer)
            contentType(ContentType.Application.Json)
        }.body()
    }

    override suspend fun deleteTransfer(cid: Int, transferId: String): String {
        val url = "$baseUrl/transfers/$cid/$transferId"
        return client.delete(url).body()
    }

    override suspend fun getAccounts(cid: Int): List<Account> {
        val url = "$baseUrl/accounts/$cid"
        return client.get(url).body()
    }

    override suspend fun getBeneficiaries(cid: Int): List<Beneficiary> {
        val url = "$baseUrl/beneficiaries/$cid"
        return client.get(url).body()
    }

    override suspend fun updateBeneficiary(cid: Int, beneficiary: Beneficiary): String {
        val url = "$baseUrl/beneficiaries/$cid"
        return client.put(url) {
            setBody(beneficiary)
            contentType(ContentType.Application.Json)
        }.body()
    }

    override suspend fun deleteBeneficiary(cid: Int, accountNo: Int): String {
        val url = "$baseUrl/beneficiaries/$cid/$accountNo"
        return client.delete(url).body()
    }

}