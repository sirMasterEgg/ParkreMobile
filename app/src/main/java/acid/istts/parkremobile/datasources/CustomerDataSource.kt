package acid.istts.parkremobile.datasources

import acid.istts.parkremobile.activities.shared.LoginActivity
import acid.istts.parkremobile.interfaces.CustomerDAO
import acid.istts.parkremobile.models.Customer
import android.view.View
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import org.json.JSONArray
import org.json.JSONObject

class CustomerDataSource(private val BASE_URL : String) : CustomerDAO {
    private val ioScope = CoroutineScope(Dispatchers.IO)

    companion object {
        private var instance: CustomerDataSource? = null
        fun getInstance(BASE_URL : String): CustomerDataSource {
            if (instance == null) {
                instance = CustomerDataSource(BASE_URL)
            }
            return instance!!
        }
    }

    override suspend fun getCustomer(id: Int): Customer? {
        TODO("Not yet implemented")
    }

    override suspend fun fetchCustomers(): List<Customer> {
        //TODO: fetch customers from API
        return listOf()
    }

    override suspend fun createCustomer(customer: Customer): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun updateCustomer(customer: Customer): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun deleteCustomer(id: Int): Boolean {
        TODO("Not yet implemented")
    }

//    private var listener: ((String) -> Unit)? = null
//    fun listener(listener: (String) -> Unit) {
//        this.listener = listener
//    }

    override fun login(username: String, password: String,
                       listener : (String) -> Unit,
    ): StringRequest {
        val strReq = object : StringRequest(
            Method.POST,
            BASE_URL + "login",
            Response.Listener {
                listener.invoke(it) },
            Response.ErrorListener {
                println(it.message)
            }
        ){
            override fun getParams(): MutableMap<String, String> {
                val params = HashMap<String, String>()
                params["email"] = username
                params["password"] = password
                return params
            }

            override fun getBody(): ByteArray? {
                val body = java.util.HashMap<String, String>()
                body["email"] = username
                body["password"] = password
                return (body as Map<*, *>?)?.let { JSONObject(it).toString().toByteArray() }
            }

            override fun getHeaders(): MutableMap<String, String> {
                val headers = HashMap<String, String>()
                headers["Accept"] = "application/json"
                return headers
            }
        }
        return strReq
    }

}