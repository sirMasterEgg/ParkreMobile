package acid.istts.parkremobile.repositories

import acid.istts.parkremobile.datasources.RoleDataSource
import acid.istts.parkremobile.interfaces.RoleDAO
import acid.istts.parkremobile.models.Role

class RoleRepository(private val roleDataSource: RoleDataSource) : RoleDAO {
    companion object {
        private var instance: RoleRepository? = null
        fun getInstance(roleDataSource: RoleDataSource): RoleRepository {
            if (instance == null) {
                instance = RoleRepository(roleDataSource)
            }
            return instance!!
        }
    }

    override suspend fun fetchRoles(): List<Role> {
        TODO("Not yet implemented")
    }

    override suspend fun getRole(id: Int): Role? {
        TODO("Not yet implemented")
    }
}