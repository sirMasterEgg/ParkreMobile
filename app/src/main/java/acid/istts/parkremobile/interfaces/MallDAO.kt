package acid.istts.parkremobile.interfaces

import acid.istts.parkremobile.models.Mall

interface MallDAO {
    suspend fun fetchMalls(): List<Mall>
    suspend fun getMall(id: Int): Mall?
    suspend fun createMall(mall: Mall): Boolean
    suspend fun updateMall(mall: Mall): Boolean
}