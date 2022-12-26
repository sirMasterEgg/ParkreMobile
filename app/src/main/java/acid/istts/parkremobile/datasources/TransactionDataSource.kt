package acid.istts.parkremobile.datasources

import acid.istts.parkremobile.interfaces.TransactionDAO
import acid.istts.parkremobile.models.Transaction

class TransactionDataSource(private val BASE_URL : String) : TransactionDAO {
    private val ioScope = kotlinx.coroutines.CoroutineScope(kotlinx.coroutines.Dispatchers.IO)

    companion object {
        private var instance : TransactionDataSource? = null
        fun getInstance(BASE_URL : String) : TransactionDataSource {
            if (instance == null) {
                instance = TransactionDataSource(BASE_URL)
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

}