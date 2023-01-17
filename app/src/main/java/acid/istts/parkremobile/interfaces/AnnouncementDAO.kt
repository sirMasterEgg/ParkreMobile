package acid.istts.parkremobile.interfaces

import acid.istts.parkremobile.models.Announcement
import android.content.Context

interface AnnouncementDAO {
    suspend fun getAnnouncement(id: Int): Announcement?
    fun fetchAnnouncement(onSuccess: (String) -> Unit, onError: (String)->Unit, context: Context): List<Announcement>
    fun fetchAnnouncementByMallId(onSuccess: (String) -> Unit, onError: (String)->Unit, context: Context, token : String): List<Announcement>
    fun createAnnouncement(header: String, content: String, token:String, onSuccess: (String) -> Unit, onError: (String) -> Unit, context: Context)
    suspend fun updateAnnouncement(announcement: Announcement): Boolean
    suspend fun deleteAnnouncement(id: Int): Boolean
    
}