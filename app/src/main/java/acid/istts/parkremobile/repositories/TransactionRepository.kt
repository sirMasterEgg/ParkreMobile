package acid.istts.parkremobile.repositories

import acid.istts.parkremobile.datasources.TransactionDataSource
import acid.istts.parkremobile.interfaces.TransactionDAO
import acid.istts.parkremobile.models.Transaction
import android.content.Context
import com.android.volley.VolleyError

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

    override suspend fun getTransactionsByCustomer(
        customer_token: String,
        onSuccess: (String) -> Unit,
        onError: (VolleyError) -> Unit,
        context: Context
    ): List<Transaction> {
        return transactionDataSource.getTransactionsByCustomer(customer_token, onSuccess, onError, context)
    }

    override suspend fun getTransactionsByMall(mallId: Int): List<Transaction> {
        TODO("Not yet implemented")
    }
}