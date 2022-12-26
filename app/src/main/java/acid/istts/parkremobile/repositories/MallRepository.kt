package acid.istts.parkremobile.repositories

import acid.istts.parkremobile.datasources.MallDataSource
import acid.istts.parkremobile.interfaces.MallDAO
import acid.istts.parkremobile.models.Mall

class MallRepository(private var mallDataSource: MallDataSource) : MallDAO {
    companion object {
        private var instance: MallRepository? = null
        fun getInstance(mallDataSource: MallDataSource): MallRepository {
            if (instance == null) {
                instance = MallRepository(mallDataSource)
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

}