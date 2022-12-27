package acid.istts.parkremobile.repositories

import acid.istts.parkremobile.datasources.VehicleDataSource
import acid.istts.parkremobile.interfaces.VehicleDAO
import acid.istts.parkremobile.models.Vehicle

class VehicleRepository(private val vehicleDataSource: VehicleDataSource) : VehicleDAO {
    companion object {
        private var instance: VehicleRepository? = null
        fun getInstance(vehicleDataSource: VehicleDataSource): VehicleRepository {
            if (instance == null) {
                instance = VehicleRepository(vehicleDataSource)
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

    override suspend fun deleteVehicle(id: Int): Boolean {
        TODO("Not yet implemented")
    }
}