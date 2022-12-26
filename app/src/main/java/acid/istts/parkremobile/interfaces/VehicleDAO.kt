package acid.istts.parkremobile.interfaces

import acid.istts.parkremobile.models.Vehicle

interface VehicleDAO {
    suspend fun fetchVehicles(customer_id : Int): List<Vehicle>
    suspend fun getVehicle(id: Int): Vehicle?
    suspend fun createVehicle(vehicle: Vehicle): Boolean
    suspend fun updateVehicle(vehicle: Vehicle): Boolean
    //TODO: deleteVehicle
}