package acid.istts.parkremobile.interfaces

import acid.istts.parkremobile.models.Customer
import com.android.volley.toolbox.StringRequest

interface CustomerDAO {
    suspend fun getCustomer(id: Int): Customer?
    suspend fun fetchCustomers(): List<Customer>
    suspend fun createCustomer(customer: Customer): Boolean
    suspend fun updateCustomer(customer: Customer): Boolean
    suspend fun deleteCustomer(id: Int): Boolean
    fun login(username: String, password: String, listener: (String) -> Unit): StringRequest
}