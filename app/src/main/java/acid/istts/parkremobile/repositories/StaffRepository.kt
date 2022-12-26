package acid.istts.parkremobile.repositories

class StaffRepository {
    companion object {
        private var instance: StaffRepository? = null
        fun getInstance(): StaffRepository {
            if (instance == null) {
                instance = StaffRepository()
            }
            return instance!!
        }
    }
}