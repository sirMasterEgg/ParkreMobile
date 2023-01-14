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
        onSuccess: (String) -> Unit,
        onError: (String) -> Unit,
        context: Context,
        token: String,
    ): List<Announcement> {
        return announcementDataSource.fetchAnnouncementByMallId(onSuccess, onError, context, token)
    }

    override fun createAnnouncement(
        header: String,
        content: String,
        token: String,
        onSuccess: (String) -> Unit,
        onError: (String) -> Unit,
        context: Context
    ) {
        return announcementDataSource.createAnnouncement(header, content, token, onSuccess, onError, context)
    }

    override suspend fun updateAnnouncement(announcement: Announcement): Boolean {
        return announcementDataSource.updateAnnouncement(announcement)
    }

    override suspend fun deleteAnnouncement(id: Int): Boolean {
        TODO("Not yet implemented")
    }
}