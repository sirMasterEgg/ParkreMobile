package acid.istts.parkremobile.datasources

import acid.istts.parkremobile.interfaces.AnnouncementDAO
import acid.istts.parkremobile.models.Announcement
import android.content.Context
import com.android.volley.DefaultRetryPolicy
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class AnnouncementDataSource(private val BASE_URL : String) :  AnnouncementDAO {
    private val ioScope = CoroutineScope(Dispatchers.IO)
    companion object {
        private var instance : AnnouncementDataSource? = null
        fun getInstance(BASE_URL : String) : AnnouncementDataSource {
            if (instance == null) {
                instance = AnnouncementDataSource(BASE_URL)
            }
            return instance!!
        }
    }

    override fun fetchAnnouncement(
        onSuccess: (String) -> Unit,
        onError: (String) -> Unit,
        context: Context,
    ): List<Announcement> {
        val req = object : StringRequest(Request.Method.GET, BASE_URL + "/staff/announcement", Response.Listener { response ->
            onSuccess.invoke(response)
        }, Response.ErrorListener { error ->
            onError.invoke(String(error.networkResponse.data, Charsets.UTF_8))
        }) {
            override fun getHeaders(): MutableMap<String, String> {
                val headers = HashMap<String, String>()
                headers["Content-Type"] = "application/json"
                return headers
            }
        }
        val queue : RequestQueue = Volley.newRequestQueue(context)
        req.retryPolicy = DefaultRetryPolicy(10000, 1, 1.0f)
        queue.add(req)
        return listOf()
    }

    override fun fetchAnnouncementByMallId(
        id: Int,
        onSuccess: (String) -> Unit,
        onError: (String) -> Unit,
        context: Context,
    ): List<Announcement> {
        val req = object : StringRequest(Request.Method.GET, BASE_URL + "announcement/staff/$id", Response.Listener { response ->
            onSuccess.invoke(response)
        }, Response.ErrorListener { error ->
            onError.invoke(String(error.networkResponse.data, Charsets.UTF_8))
        }) {
            override fun getHeaders(): MutableMap<String, String> {
                val headers = HashMap<String, String>()
                headers["Content-Type"] = "application/json"
                return headers
            }
        }
        val queue : RequestQueue = Volley.newRequestQueue(context)
        queue.add(req)
        return listOf()
    }

    override suspend fun getAnnouncement(id: Int): Announcement? {
        TODO("Not yet implemented")
    }

    override suspend fun createAnnouncement(announcement: Announcement): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun updateAnnouncement(announcement: Announcement): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun deleteAnnouncement(id: Int): Boolean {
        TODO("Not yet implemented")
    }
}
