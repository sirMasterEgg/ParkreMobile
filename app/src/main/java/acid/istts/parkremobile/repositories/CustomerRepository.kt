package acid.istts.parkremobile.repositories

import acid.istts.parkremobile.datasources.CustomerDataSource
import acid.istts.parkremobile.interfaces.CustomerDAO
import acid.istts.parkremobile.models.Customer
import android.content.Context
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest

class CustomerRepository(private var customerDataSource: CustomerDataSource) : CustomerDAO {
    companion object {
        private var instance: CustomerRepository? = null
        fun getInstance(customerDataSource: CustomerDataSource): CustomerRepository {
            if (instance == null) {
                instance = CustomerRepository(customerDataSource)
            }
            return instance!!
        }
    }

    override fun getCustomer(
        id: Int,
        onSuccess: (String) -> Unit,
        onError: (VolleyError) -> Unit,
        context: Context
    ): Customer? {
        return customerDataSource.getCustomer(id, onSuccess, onError, context)
    }

    override fun fetchCustomers(
        onSuccess: (String) -> Unit,
        onError: (VolleyError) -> Unit,
        context: Context
    ): List<Customer> {
        return customerDataSource.fetchCustomers(onSuccess, onError, context)
    }

    override suspend fun createCustomer(customer: Customer): Boolean {
        return customerDataSource.createCustomer(customer)
    }

    override suspend fun updateCustomer(customer: Customer): Boolean {
        return customerDataSource.updateCustomer(customer)
    }

    override suspend fun deleteCustomer(id: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun login(username: String, password: String, onSuccess : (String) -> Unit): StringRequest {
        return customerDataSource.login(username, password, onSuccess)
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
        return customerDataSource.register(username, password, passwordConfirm, name, phone, address, onSuccess, onError)
    }

}