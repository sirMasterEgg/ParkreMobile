package acid.istts.parkremobile.interfaces

import acid.istts.parkremobile.models.Staff

interface StaffDAO {
    suspend fun fetchStaffs(): List<Staff>
    suspend fun getStaff(id: Int): Staff?
    suspend fun createStaff(staff: Staff): Boolean
    suspend fun updateStaff(staff: Staff): Boolean
    //TODO: deleteStaff
}