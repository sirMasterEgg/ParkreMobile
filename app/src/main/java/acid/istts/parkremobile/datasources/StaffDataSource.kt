package acid.istts.parkremobile.datasources

import acid.istts.parkremobile.interfaces.StaffDAO
import acid.istts.parkremobile.models.Staff
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class StaffDataSource(private val BASE_URL : String) : StaffDAO {
    private val ioScope = CoroutineScope(Dispatchers.IO)

    companion object {
        private var instance : StaffDataSource? = null
        fun getInstance(BASE_URL : String) : StaffDataSource {
            if (instance == null) {
                instance = StaffDataSource(BASE_URL)
            }
            return instance!!
        }
    }

    override suspend fun fetchStaffs(): List<Staff> {
        TODO("Not yet implemented")
    }

    override suspend fun getStaff(id: Int): Staff? {
        TODO("Not yet implemented")
    }

    override suspend fun createStaff(staff: Staff): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun updateStaff(staff: Staff): Boolean {
        TODO("Not yet implemented")
    }

}