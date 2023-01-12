package acid.istts.parkremobile.datasources

import acid.istts.parkremobile.interfaces.VehicleDAO
import acid.istts.parkremobile.models.Vehicle
import android.content.Context
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
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

    override fun fetchVehicles(
        customer_id: Int,
        onSuccess: (String) -> Unit,
        onError: (VolleyError) -> Unit,
        context: Context
    ): List<Vehicle>? {
        val request = object : StringRequest(
            Method.GET,
            "$BASE_URL/customer/",
            Response.Listener { response ->
                onSuccess.invoke(response)
            },
            Response.ErrorListener { error ->
                onError.invoke(error)
            }
        ) {
            override fun getBodyContentType(): String {
                return "application/json; charset=utf-8"
            }
        }
        val queue : RequestQueue = Volley.newRequestQueue(context)
        queue.add(request)

        return null
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