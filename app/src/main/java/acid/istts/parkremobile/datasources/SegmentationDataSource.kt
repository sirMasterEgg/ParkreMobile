package acid.istts.parkremobile.datasources

import acid.istts.parkremobile.interfaces.SegmentationDAO
import acid.istts.parkremobile.models.Segmentation
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class SegmentationDataSource(private val BASE_URL : String) : SegmentationDAO {
    private val ioScope = CoroutineScope(Dispatchers.IO)

    companion object {
        private var instance : SegmentationDataSource? = null
        fun getInstance(BASE_URL : String) : SegmentationDataSource {
            if (instance == null) {
                instance = SegmentationDataSource(BASE_URL)
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

}