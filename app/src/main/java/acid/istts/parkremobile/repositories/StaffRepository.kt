package acid.istts.parkremobile.repositories

import acid.istts.parkremobile.datasources.StaffDataSource
import acid.istts.parkremobile.interfaces.StaffDAO
import acid.istts.parkremobile.models.Staff
import com.android.volley.toolbox.StringRequest

class StaffRepository(private val staffDataSource: StaffDataSource) : StaffDAO {
    companion object {
        private var instance: StaffRepository? = null
        fun getInstance(staffDataSource: StaffDataSource): StaffRepository {
            if (instance == null) {
                instance = StaffRepository(staffDataSource)
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

    override suspend fun deleteStaff(id: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun login(
        username: String,
        password: String,
        onSuccess: (String) -> Unit
    ): StringRequest {
        TODO("Not yet implemented")
    }
}