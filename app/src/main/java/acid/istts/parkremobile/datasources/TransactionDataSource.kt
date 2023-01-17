package acid.istts.parkremobile.datasources

import acid.istts.parkremobile.interfaces.TransactionDAO
import acid.istts.parkremobile.models.Transaction
import android.content.Context
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

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

    override suspend fun getTransactionsByCustomer(
        customer_token: String,
        onSuccess: (String) -> Unit,
        onError: (VolleyError) -> Unit,
        context: Context
    ): List<Transaction> {
        val request = object : StringRequest(
            Method.GET,
            "$BASE_URL/customer/vehicle",
            Response.Listener { response ->
                onSuccess.invoke(response)
            },
            Response.ErrorListener { error ->
                onError.invoke(error)
            }
        ) {
            override fun getBodyContentType(): String {
                return "application/json; charset=utf-8"
            }

            override fun getHeaders(): MutableMap<String, String> {
                val headers = HashMap<String, String>()
                headers["Accept"] = "application/json"
                headers["Authorization"] = "Bearer $customer_token"
                return headers
            }
        }
        val queue : RequestQueue = Volley.newRequestQueue(context)
        queue.add(request)

        return arrayListOf()
    }

    override suspend fun getTransactionsByMall(mallId: Int): List<Transaction> {
        TODO("Not yet implemented")
    }

}