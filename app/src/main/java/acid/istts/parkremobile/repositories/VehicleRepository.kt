package acid.istts.parkremobile.repositories

import acid.istts.parkremobile.datasources.VehicleDataSource
import acid.istts.parkremobile.interfaces.VehicleDAO
import acid.istts.parkremobile.models.Vehicle
import android.content.Context
import com.android.volley.VolleyError

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

    override fun fetchVehicles(
        customer_token: String,
        onSuccess: (String) -> Unit,
        onError: (VolleyError) -> Unit,
        context: Context
    ): List<Vehicle>? {
        return vehicleDataSource.fetchVehicles(customer_token, onSuccess, onError, context)
    }

    override suspend fun getVehicle(id: Int): Vehicle? {
        TODO("Not yet implemented")
    }

    override suspend fun createVehicle(
        vehicle_name: String,
        vehicle_plate: String,
        customer_id: Int,
        customer_token: String,
        onSuccess: (String) -> Unit,
        onError: (VolleyError) -> Unit,
        context: Context
    ): Boolean {
        return vehicleDataSource.createVehicle(vehicle_name, vehicle_plate, customer_id, customer_token, onSuccess, onError, context)
    }

    override suspend fun updateVehicle(vehicle: Vehicle): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun deleteVehicle(id: Int): Boolean {
        TODO("Not yet implemented")
    }
}