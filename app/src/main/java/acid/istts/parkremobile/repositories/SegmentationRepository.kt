package acid.istts.parkremobile.repositories

class SegmentationRepository {
    companion object {
        private var instance: SegmentationRepository? = null
        fun getInstance(): SegmentationRepository {
            if (instance == null) {
                instance = SegmentationRepository()
            }
            return instance!!
        }
    }
}