package acid.istts.parkremobile.datasources

import acid.istts.parkremobile.interfaces.VehicleDAO
import acid.istts.parkremobile.models.Vehicle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class VehicleDataSource(private val BASE_URL : String) : VehicleDAO {
    private val ioScope = CoroutineScope(Dispatchers.IO)

    companion object {
        private var instance : VehicleDataSource? = null
        fun getInstance(BASE_URL : String) : VehicleDataSource {
            if (instance == null) {
                instance = VehicleDataSource(BASE_URL)
            }
            return instance!!
        }
    }

    override suspend fun fetchVehicles(customer_id: Int): List<Vehicle> {
        TODO("Not yet implemented")
    }

    override suspend fun getVehicle(id: Int): Vehicle? {
        TODO("Not yet implemented")
    }

    override suspend fun createVehicle(vehicle: Vehicle): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun updateVehicle(vehicle: Vehicle): Boolean {
        TODO("Not yet implemented")
    }
}