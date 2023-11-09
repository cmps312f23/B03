package com.cmps312.bankingapp.data.model

import kotlinx.coroutines.flow.Flow

//contract class
interface BankService {
    fun getTransfers(cid: Int): Flow<List<Transfer>>
    suspend fun addTransfer(transfer: Transfer): Transfer
    suspend fun deleteTransfer(cid: Int , transferId: String): String
    suspend fun getAccounts(cid: Int): List<Account>
    suspend fun getBeneficiaries(cid: Int): List<Beneficiary>
    suspend fun updateBeneficiary(cid: Int, beneficiary: Beneficiary): String
    suspend fun deleteBeneficiary(cid: Int , accountNo: Int): String
}