package acid.istts.parkremobile.interfaces

import acid.istts.parkremobile.models.Staff
import com.android.volley.toolbox.StringRequest

interface StaffDAO {
    suspend fun fetchStaffs(): List<Staff>
    suspend fun getStaff(id: Int): Staff?
    suspend fun createStaff(staff: Staff): Boolean
    suspend fun updateStaff(staff: Staff): Boolean
    suspend fun deleteStaff(id: Int): Boolean
    fun login(username: String, password: String, onSuccess : (String) -> Unit): StringRequest
}