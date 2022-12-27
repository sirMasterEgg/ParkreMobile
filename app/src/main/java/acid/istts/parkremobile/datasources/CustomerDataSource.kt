package acid.istts.parkremobile.datasources

import acid.istts.parkremobile.interfaces.CustomerDAO
import acid.istts.parkremobile.models.Customer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

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

}