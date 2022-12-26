package acid.istts.parkremobile.repositories

class CustomerRepository {
    companion object {
        private var instance: CustomerRepository? = null
        fun getInstance(): CustomerRepository {
            if (instance == null) {
                instance = CustomerRepository()
            }
            return instance!!
        }
    }
}