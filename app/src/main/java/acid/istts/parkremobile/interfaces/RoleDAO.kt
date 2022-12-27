package acid.istts.parkremobile.interfaces

import acid.istts.parkremobile.models.Role

interface RoleDAO {
    suspend fun fetchRoles(): List<Role>
    suspend fun getRole(id: Int): Role?
}