package acid.istts.parkremobile.repositories

import acid.istts.parkremobile.datasources.TransactionDataSource
import acid.istts.parkremobile.interfaces.TransactionDAO
import acid.istts.parkremobile.models.Transaction

class TransactionRepository(private val transactionDataSource: TransactionDataSource) :
    TransactionDAO {
    companion object {
        private var instance: TransactionRepository? = null
        fun getInstance(transactionDataSource: TransactionDataSource): TransactionRepository {
            if (instance == null) {
                instance = TransactionRepository(transactionDataSource)
            }
            return instance!!
        }
    }

    override suspend fun fetchTransactions(): List<Transaction> {
        TODO("Not yet implemented")
    }

    override suspend fun getTransaction(id: Int): Transaction? {
        TODO("Not yet implemented")
    }

    override suspend fun createTransaction(transaction: Transaction): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun updateTransaction(transaction: Transaction): Boolean {
        TODO("Not yet implemented")
    }

    override fun getTransactionsByCustomer(customerId: Int): List<Transaction> {
        TODO("Not yet implemented")
    }

    override suspend fun getTransactionsByMall(mallId: Int): List<Transaction> {
        TODO("Not yet implemented")
    }
}