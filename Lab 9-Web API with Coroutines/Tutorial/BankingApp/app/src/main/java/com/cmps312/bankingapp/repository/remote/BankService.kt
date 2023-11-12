package com.cmps312.bankingapp.repository.remote

import com.cmps312.bankingapp.model.Account
import com.cmps312.bankingapp.model.Beneficiary
import com.cmps312.bankingapp.model.Transfer
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