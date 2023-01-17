package acid.istts.parkremobile.interfaces

import acid.istts.parkremobile.models.Mall
import android.content.Context

interface MallDAO {
    fun fetchMalls(onSuccess : (String) -> Unit, onError : (String) -> Unit, context : Context)
    suspend fun getMall(id: Int): Mall?
    suspend fun createMall(mall: Mall): Boolean
    suspend fun updateMall(mall: Mall): Boolean
    suspend fun deleteMall(id: Int): Boolean
    fun getMallAnnouncements(slug: String, onSuccess: (String) -> Unit, onError: (String) -> Unit, context: Context)
}