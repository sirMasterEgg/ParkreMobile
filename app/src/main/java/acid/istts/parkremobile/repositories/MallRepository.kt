package acid.istts.parkremobile.repositories

class MallRepository {
    companion object {
        private var instance: MallRepository? = null
        fun getInstance(): MallRepository {
            if (instance == null) {
                instance = MallRepository()
            }
            return instance!!
        }
    }
}