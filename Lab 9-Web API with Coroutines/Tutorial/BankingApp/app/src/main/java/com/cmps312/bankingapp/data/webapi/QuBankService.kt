package com.cmps312.bankingapp.data.webapi

import com.cmps312.bankingapp.data.model.Account
import com.cmps312.bankingapp.data.model.BankService
import com.cmps312.bankingapp.data.model.Beneficiary
import com.cmps312.bankingapp.data.model.Transfer
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

//create a class that allows us to talk to the server
//CRUD [create read update and delete

class QuBankService : BankService {
    //    create the base url
    val baseUrl = "https://cmps312banking.cyclic.app/api"

    //    create the client
    private val client = HttpClient(OkHttp) {
        install(ContentNegotiation){
            json(
                json = Json {
                    ignoreUnknownKeys = true
                    prettyPrint = true
                }
            )
        }
    }

    override suspend fun getTransfers(cid: Int): List<Transfer> {
        TODO("Not yet implemented")
    }

    override suspend fun addTransfer(transfer: Transfer): Transfer {
        TODO("Not yet implemented")
    }

    override suspend fun deleteTransfer(cid: Int, transferId: String): String {
        TODO("Not yet implemented")
    }

    override suspend fun getAccounts(cid: Int): List<Account> {
        TODO("Not yet implemented")
    }

    override suspend fun getBeneficiaries(cid: Int): List<Beneficiary> {
        TODO("Not yet implemented")
    }

    override suspend fun updateBeneficiary(cid: Int, beneficiary: Beneficiary): String {
        TODO("Not yet implemented")
    }

    override suspend fun deleteBeneficiary(cid: Int, accountNo: Int): String {
        TODO("Not yet implemented")
    }

}