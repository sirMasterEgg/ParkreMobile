package acid.istts.parkremobile.datasources

import acid.istts.parkremobile.interfaces.RoleDAO
import acid.istts.parkremobile.models.Role

class RoleDataSource(private val BASE_URL : String) : RoleDAO {
    companion object {
        private var instance : RoleDataSource? = null
        fun getInstance(BASE_URL : String) : RoleDataSource {
            if (instance == null) {
                instance = RoleDataSource(BASE_URL)
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