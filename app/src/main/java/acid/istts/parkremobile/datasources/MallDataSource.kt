package acid.istts.parkremobile.datasources

import acid.istts.parkremobile.interfaces.MallDAO
import acid.istts.parkremobile.models.Mall
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class MallDataSource(private val BASE_URL: String) : MallDAO {
    private val ioScope = CoroutineScope(Dispatchers.IO)

    companion object {
        private var instance: MallDataSource? = null
        fun getInstance(BASE_URL: String): MallDataSource {
            if (instance == null) {
                instance = MallDataSource(BASE_URL)
            }
            return instance!!
        }
    }

    override suspend fun fetchMalls(): List<Mall> {
        TODO("Not yet implemented")
    }

    override suspend fun getMall(id: Int): Mall? {
        TODO("Not yet implemented")
    }

    override suspend fun createMall(mall: Mall): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun updateMall(mall: Mall): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun deleteMall(id: Int): Boolean {
        TODO("Not yet implemented")
    }
}