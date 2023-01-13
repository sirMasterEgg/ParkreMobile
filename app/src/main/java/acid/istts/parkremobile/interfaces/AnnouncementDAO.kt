package acid.istts.parkremobile.interfaces

import acid.istts.parkremobile.models.Announcement
import android.content.Context

interface AnnouncementDAO {
    suspend fun getAnnouncement(id: Int): Announcement?
    fun fetchAnnouncement(onSuccess: (String) -> Unit, onError: (String)->Unit, context: Context): List<Announcement>
    fun fetchAnnouncementByMallId(onSuccess: (String) -> Unit, onError: (String)->Unit, context: Context, token : String): List<Announcement>
    suspend fun createAnnouncement(announcement: Announcement): Boolean
    suspend fun updateAnnouncement(announcement: Announcement): Boolean
    suspend fun deleteAnnouncement(id: Int): Boolean
}