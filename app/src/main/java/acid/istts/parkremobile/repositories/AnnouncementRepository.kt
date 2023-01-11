package acid.istts.parkremobile.repositories

import acid.istts.parkremobile.datasources.AnnouncementDataSource
import acid.istts.parkremobile.interfaces.AnnouncementDAO
import acid.istts.parkremobile.models.Announcement
import android.content.Context

class AnnouncementRepository(private var announcementDataSource: AnnouncementDataSource) : AnnouncementDAO {
    companion object{
        private var instance: AnnouncementRepository? = null
        fun getInstance(announcementDataSource: AnnouncementDataSource): AnnouncementRepository {
            if (instance == null) {
                instance = AnnouncementRepository(announcementDataSource)
            }
            return instance!!
        }
    }

    override suspend fun getAnnouncement(id: Int): Announcement? {
        return announcementDataSource.getAnnouncement(id)
    }

    override fun fetchAnnouncement(
        onSuccess: (String) -> Unit,
        onError: (String) -> Unit,
        context: Context,
    ): List<Announcement> {
        return announcementDataSource.fetchAnnouncement(onSuccess, onError, context)
    }

    override fun fetchAnnouncementByMallId(
        id: Int,
        onSuccess: (String) -> Unit,
        onError: (String) -> Unit,
        context: Context,
    ): List<Announcement> {
        return announcementDataSource.fetchAnnouncementByMallId(id, onSuccess, onError, context)
    }

    override suspend fun createAnnouncement(announcement: Announcement): Boolean {
        return announcementDataSource.createAnnouncement(announcement)
    }

    override suspend fun updateAnnouncement(announcement: Announcement): Boolean {
        return announcementDataSource.updateAnnouncement(announcement)
    }

    override suspend fun deleteAnnouncement(id: Int): Boolean {
        TODO("Not yet implemented")
    }
}