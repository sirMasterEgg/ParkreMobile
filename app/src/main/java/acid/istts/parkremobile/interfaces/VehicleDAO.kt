package acid.istts.parkremobile.interfaces

import acid.istts.parkremobile.models.Vehicle
import android.content.Context
import com.android.volley.VolleyError

interface VehicleDAO {
    fun fetchVehicles(
        customer_token : String,
        onSuccess: (String) -> Unit,
        onError: (VolleyError) -> Unit,
        context: Context
    ): List<Vehicle>?
    suspend fun getVehicle(id: Int): Vehicle?
    suspend fun createVehicle(vehicle_name: String,
    vehicle_plate: String,
    customer_id: Int, customer_token: String,
    onSuccess: (String) -> Unit,
    onError: (VolleyError) -> Unit,
    context: Context): Boolean
    suspend fun updateVehicle(vehicle: Vehicle): Boolean
    suspend fun deleteVehicle(id: Int): Boolean
}