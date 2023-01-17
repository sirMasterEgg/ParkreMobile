package acid.istts.parkremobile.datasources

import acid.istts.parkremobile.interfaces.MallDAO
import acid.istts.parkremobile.models.Mall
import android.content.Context
import com.android.volley.DefaultRetryPolicy
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers


class MallDataSource(private val BASE_URL: String) : MallDAO {
    private val ioScope = CoroutineScope(Dispatchers.IO)

    companion object {
        private var instance: MallDataSource? = null
        fun getInstance(BASE_URL: String): MallDataSource {
            if (instance == null) {
                instance = MallDataSource(BASE_URL)
            }
            return instance!!
        }
    }

    override fun fetchMalls(
        onSuccess: (String) -> Unit,
        onError: (String) -> Unit,
        context: Context
    ) {
        val req = object : StringRequest(Method.GET, BASE_URL + "mall", Response.Listener { response ->
            onSuccess.invoke(response)
        }, Response.ErrorListener { error ->
            if (error.networkResponse.data != null) {
                onError.invoke(String(error.networkResponse.data, Charsets.UTF_8))
            } else {
                onError.invoke("Error")
            }
        }) {
            override fun getHeaders(): MutableMap<String, String> {
                val headers = HashMap<String, String>()
                headers["Accept"] = "application/json"
                return headers
            }
        }
        val queue : RequestQueue = Volley.newRequestQueue(context)
        req.retryPolicy = DefaultRetryPolicy(10000, 1, 1.0f)
        queue.add(req)
    }

    override suspend fun getMall(id: Int): Mall? {
        TODO("Not yet implemented")
    }

    override suspend fun createMall(mall: Mall): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun updateMall(mall: Mall): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun deleteMall(id: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun getMallAnnouncements(
        slug: String,
        onSuccess: (String) -> Unit,
        onError: (String) -> Unit,
        context: Context
    ) {
        val req = object : StringRequest(Method.GET, BASE_URL + "mall/$slug/announcement", Response.Listener { response ->
            onSuccess.invoke(response)
        }, Response.ErrorListener { error ->
            onError.invoke(String(error.networkResponse.data, Charsets.UTF_8))
        }) {
            override fun getHeaders(): MutableMap<String, String> {
                val headers = HashMap<String, String>()
                headers["Accept"] = "application/json"
                return headers
            }
        }
        val queue : RequestQueue = Volley.newRequestQueue(context)
        queue.add(req)
    }
}