package acid.istts.parkremobile.interfaces

import acid.istts.parkremobile.models.Staff
import android.content.Context
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest

interface StaffDAO {
    fun fetchStaffs(onSuccess: (String) -> Unit, onError: (String)-> Unit, context: Context): List<Staff>
    fun getStaff(id: Int, onSuccess: (String) -> Unit,
                         onError: (String) -> Unit,
                         context: Context)
    suspend fun createStaff(staff: Staff): Boolean
    suspend fun updateStaff(staff: Staff): Boolean
    suspend fun deleteStaff(id: Int): Boolean
    fun login(username: String, password: String, onSuccess : (String) -> Unit): StringRequest
}