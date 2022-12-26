package acid.istts.parkremobile.interfaces

import acid.istts.parkremobile.models.Segmentation

interface SegmentationDAO{
    suspend fun fetchSegmentations(mall_id : Int): List<Segmentation>?
    suspend fun getSegmentation(id: Int): Segmentation?
    suspend fun createSegmentation(segmentation: Segmentation): Boolean
    suspend fun updateSegmentation(segmentation: Segmentation): Boolean
    //TODO: deleteSegmentation
}