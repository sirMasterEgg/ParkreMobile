package acid.istts.parkremobile.datasources

import acid.istts.parkremobile.interfaces.CustomerDAO
import acid.istts.parkremobile.models.Customer
import android.util.Log
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import java.nio.charset.Charset

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

    override fun login(username: String, password: String, onSuccess : (String) -> Unit): StringRequest {
        val strReq = object : StringRequest(
            Method.POST,
            BASE_URL + "login",
            Response.Listener {
                onSuccess.invoke(it)
            },
            Response.ErrorListener {
                Log.e("Volley", String(it.networkResponse.data, Charsets.UTF_8))
            }
        ){
            override fun getParams(): MutableMap<String, String> {
                val params = HashMap<String, String>()
                params["email"] = username
                params["password"] = password
                return params
            }

            override fun getHeaders(): MutableMap<String, String> {
                val headers = HashMap<String, String>()
                headers["Accept"] = "application/json"
                headers["Content-Type"] = "application/x-www-form-urlencoded"
                return headers
            }
        }
        return strReq
    }

    override fun register(
        username: String,
        password: String,
        passwordConfirm: String,
        name: String,
        phone: String,
        address: String?,
        onSuccess: (String) -> Unit,
        onError: (VolleyError) -> Unit
    ): StringRequest {
        val strReq = object : StringRequest(
            Method.POST,
            BASE_URL + "register",
            Response.Listener {
                onSuccess.invoke(it)
            },
            Response.ErrorListener {
                onError.invoke(it)
            }
        ){
            override fun getParams(): MutableMap<String, String> {
                val params = HashMap<String, String>()
                params["email"] = username
                params["password"] = password
                params["password_confirmation"] = passwordConfirm
                params["name"] = name
                params["phone"] = phone
                params["address"] = address ?: ""
                return params
            }

            override fun getHeaders(): MutableMap<String, String> {
                val headers = HashMap<String, String>()
                headers["Accept"] = "application/json"
                headers["Content-Type"] = "application/x-www-form-urlencoded"
                return headers
            }
        }
        return strReq
    }

}