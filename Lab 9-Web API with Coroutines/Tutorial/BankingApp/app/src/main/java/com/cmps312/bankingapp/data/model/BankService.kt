package com.cmps312.bankingapp.data.model

//contract class
interface BankService {
    suspend fun getTransfers(cid: Int): List<Transfer>
    suspend fun addTransfer(transfer: Transfer): Transfer
    suspend fun deleteTransfer(cid: Int , transferId: String): String
    suspend fun getAccounts(cid: Int): List<Account>
    suspend fun getBeneficiaries(cid: Int): List<Beneficiary>
    suspend fun updateBeneficiary(cid: Int, beneficiary: Beneficiary): String
    suspend fun deleteBeneficiary(cid: Int , account: Int): String
}