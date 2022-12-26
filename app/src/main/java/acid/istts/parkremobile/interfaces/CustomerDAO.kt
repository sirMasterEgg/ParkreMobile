package acid.istts.parkremobile.interfaces

import acid.istts.parkremobile.models.Customer

interface CustomerDAO {
    suspend fun getCustomer(id: Int): Customer?
    suspend fun fetchCustomers(): List<Customer>
    suspend fun createCustomer(customer: Customer): Boolean
    suspend fun updateCustomer(customer: Customer): Boolean
    //TODO: deleteCustomer
}