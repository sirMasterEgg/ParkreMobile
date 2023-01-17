package acid.istts.parkremobile.datasources

import acid.istts.parkremobile.interfaces.ReservationDAO
import acid.istts.parkremobile.models.Reservation
import android.content.Context
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class ReservationDataSource(private val BASE_URL : String) : ReservationDAO {
    private val ioScope = CoroutineScope(Dispatchers.IO)

    companion object {
        private var instance : ReservationDataSource? = null
        fun getInstance(BASE_URL : String) : ReservationDataSource {
            if (instance == null) {
                instance = ReservationDataSource(BASE_URL)
            }
            return instance!!
        }
    }

    override fun fetchReservations(
        onSuccess: (String) -> Unit,
        onError: (String) -> Unit,
        context: Context,
        token: String
    ) {
        val req = object : StringRequest(Method.GET, BASE_URL + "staff", Response.Listener {
                response -> onSuccess.invoke(response)
        }, Response.ErrorListener { error ->
            onError.invoke(String(error.networkResponse.data, Charsets.UTF_8))
        }) {
            override fun getHeaders(): MutableMap<String, String> {
                val headers = HashMap<String, String>()
                headers["Accept"] = "application/json"
                headers["Bypass-Tunnel-Reminder"] = "true"
                headers["Authorization"] = "Bearer $token"
                return headers
            }
        }

        val queue : RequestQueue = Volley.newRequestQueue(context)
        queue.add(req)
    }

    override suspend fun getReservation(id: Int): Reservation? {
        TODO("Not yet implemented")
    }

    override suspend fun createReservation(reservation: Reservation): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun updateReservation(reservation: Reservation): Boolean {
        TODO("Not yet implemented")
    }

}
