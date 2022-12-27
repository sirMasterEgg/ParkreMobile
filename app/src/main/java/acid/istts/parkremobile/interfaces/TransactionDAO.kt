package acid.istts.parkremobile.interfaces

import acid.istts.parkremobile.models.Transaction

interface TransactionDAO {
    suspend fun fetchTransactions(): List<Transaction>
    suspend fun getTransaction(id: Int): Transaction?
    suspend fun createTransaction(transaction: Transaction): Boolean
    suspend fun updateTransaction(transaction: Transaction): Boolean
    suspend fun getTransactionsByCustomer(customerId: Int): List<Transaction>
    suspend fun getTransactionsByMall(mallId: Int): List<Transaction>
}