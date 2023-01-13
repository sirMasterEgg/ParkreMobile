package acid.istts.parkremobile.repositories

import acid.istts.parkremobile.datasources.StaffDataSource
import acid.istts.parkremobile.interfaces.StaffDAO
import acid.istts.parkremobile.models.Staff
import android.content.Context
import android.security.identity.CipherSuiteNotSupportedException
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

    override fun fetchStaffs(
        onSuccess: (String) -> Unit,
        onError: (String) -> Unit,
        context: Context
    ): List<Staff> {
        return staffDataSource.fetchStaffs(onSuccess, onError, context)
    }

//    override fun fetchStaffs(): List<Staff> {
//        TODO("Not yet implemented")
//    }

    override fun getStaff(
        id: Int,
        onSuccess: (String) -> Unit,
        onError: (String) -> Unit,
        context: Context
    ) {
        return staffDataSource.getStaff(id, onSuccess, onError, context)
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
        return staffDataSource.login(username, password, onSuccess)
    }
}