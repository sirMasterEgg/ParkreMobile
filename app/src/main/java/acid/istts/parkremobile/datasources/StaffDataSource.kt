package acid.istts.parkremobile.datasources

import acid.istts.parkremobile.interfaces.StaffDAO
import acid.istts.parkremobile.models.Staff
import android.content.Context
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import android.util.Log

class StaffDataSource(private val BASE_URL : String) : StaffDAO {
    private val ioScope = CoroutineScope(Dispatchers.IO)

    companion object {
        private var instance : StaffDataSource? = null
        fun getInstance(BASE_URL : String) : StaffDataSource {
            if (instance == null) {
                instance = StaffDataSource(BASE_URL)
            }
            return instance!!
        }
    }

    override fun fetchStaffs(
        onSuccess: (String) -> Unit,
        onError: (String) -> Unit,
        context : Context
    ): List<Staff> {
        val req = object : StringRequest(Method.GET, BASE_URL + "staff", Response.Listener {
            response -> onSuccess.invoke(response)
        }, Response.ErrorListener {
//            error -> onError.invoke(String(error.networkResponse.data, Charsets.UTF_8))
            Log.e("error fetch staff", it.toString())
        }){
            override fun getHeaders() : MutableMap<String, String>{
                val headers = HashMap<String, String>()
                headers["Content-Type"] = "application/json"
                return headers
            }
        }

        val queue : RequestQueue = Volley.newRequestQueue(context)
        queue.add(req)
        return emptyList()
    }

    override fun getStaff(
        id: Int,
        onSuccess: (String) -> Unit,
        onError: (String) -> Unit,
        context: Context
    ) {
        val request = object : StringRequest(
            Method.GET,
            "$BASE_URL/staff/$id",
            Response.Listener { response ->
                onSuccess.invoke(response)
            },
            Response.ErrorListener { error ->
                onError.invoke(String(error.networkResponse.data, Charsets.UTF_8))
            }
        ) {
            override fun getBodyContentType(): String {
                return "application/json; charset=utf-8"
            }
        }
        val queue : RequestQueue = Volley.newRequestQueue(context)
        queue.add(request)
    }

    override suspend fun createStaff(staff: Staff): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun updateStaff(staff: Staff): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun deleteStaff(id: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun login(
        username: String,
        password: String,
        onSuccess: (String) -> Unit
    ): StringRequest {
        val req = object : StringRequest(Method.POST, BASE_URL + "login", Response.Listener {
            onSuccess.invoke(it)
        }, Response.ErrorListener {
            Log.e("error login staff", it.message.toString())
        }){
            override fun getParams(): MutableMap<String, String> {
                val params = HashMap<String, String>()
                params["email"] = username
                params["password"] = password
                return params
            }

            override fun getHeaders() : MutableMap<String, String>{
                val headers = HashMap<String, String>()
                headers["Accept"] = "application/json"
                headers["Content-Type"] = "application/x-www-form-urlencoded"
                headers["Bypass-Tunnel-Reminder"] = "true"
                return headers
            }
        }
        return req
    }

}