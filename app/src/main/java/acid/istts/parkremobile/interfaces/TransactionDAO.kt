package acid.istts.parkremobile.interfaces

import acid.istts.parkremobile.models.Transaction
import android.content.Context
import com.android.volley.VolleyError

interface TransactionDAO {
    suspend fun fetchTransactions(): List<Transaction>
    suspend fun getTransaction(id: Int): Transaction?
    suspend fun createTransaction(transaction: Transaction): Boolean
    suspend fun updateTransaction(transaction: Transaction): Boolean
    suspend fun getTransactionsByCustomer(customer_token: String,
                                          onSuccess: (String) -> Unit,
                                          onError: (VolleyError) -> Unit,
                                          context: Context
    ): List<Transaction>
    suspend fun getTransactionsByMall(mallId: Int): List<Transaction>
}