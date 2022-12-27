package acid.istts.parkremobile.repositories

import acid.istts.parkremobile.datasources.SegmentationDataSource
import acid.istts.parkremobile.interfaces.SegmentationDAO
import acid.istts.parkremobile.models.Segmentation

class SegmentationRepository(private val segmentationDataSource: SegmentationDataSource) : SegmentationDAO {
    companion object {
        private var instance: SegmentationRepository? = null
        fun getInstance(segmentationDataSource: SegmentationDataSource): SegmentationRepository {
            if (instance == null) {
                instance = SegmentationRepository(segmentationDataSource)
            }
            return instance!!
        }
    }

    override suspend fun fetchSegmentations(mall_id: Int): List<Segmentation>? {
        TODO("Not yet implemented")
    }

    override suspend fun getSegmentation(id: Int): Segmentation? {
        TODO("Not yet implemented")
    }

    override suspend fun createSegmentation(segmentation: Segmentation): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun updateSegmentation(segmentation: Segmentation): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun deleteSegmentation(id: Int): Boolean {
        TODO("Not yet implemented")
    }
}