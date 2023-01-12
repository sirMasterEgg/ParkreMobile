package acid.istts.parkremobile.interfaces

import acid.istts.parkremobile.models.Vehicle
import android.content.Context
import com.android.volley.VolleyError

interface VehicleDAO {
    fun fetchVehicles(
        customer_id : Int,
        onSuccess: (String) -> Unit,
        onError: (VolleyError) -> Unit,
        context: Context
    ): List<Vehicle>?
    suspend fun getVehicle(id: Int): Vehicle?
    suspend fun createVehicle(vehicle: Vehicle): Boolean
    suspend fun updateVehicle(vehicle: Vehicle): Boolean
    suspend fun deleteVehicle(id: Int): Boolean
}