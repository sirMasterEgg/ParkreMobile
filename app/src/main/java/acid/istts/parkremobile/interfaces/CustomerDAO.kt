package acid.istts.parkremobile.interfaces

import acid.istts.parkremobile.models.Customer
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest

interface CustomerDAO {
    suspend fun getCustomer(id: Int): Customer?
    suspend fun fetchCustomers(): List<Customer>
    suspend fun createCustomer(customer: Customer): Boolean
    suspend fun updateCustomer(customer: Customer): Boolean
    suspend fun deleteCustomer(id: Int): Boolean
    fun login(username: String, password: String, onSuccess : (String) -> Unit): StringRequest
    fun register(username: String, password: String, passwordConfirm: String, name: String, phone: String, address: String?, onSuccess: (String) -> Unit, onError: (VolleyError) -> Unit): StringRequest
}