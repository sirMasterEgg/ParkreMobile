package acid.istts.parkremobile.repositories

import acid.istts.parkremobile.datasources.MallDataSource
import acid.istts.parkremobile.interfaces.MallDAO
import acid.istts.parkremobile.models.Mall
import android.content.Context

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

    override fun fetchMalls(
        onSuccess: (String) -> Unit,
        onError: (String) -> Unit,
        context: Context
    ) {
        return mallDataSource.fetchMalls(onSuccess, onError, context)
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

    override fun getMallAnnouncements(
        slug: String,
        onSuccess: (String) -> Unit,
        onError: (String) -> Unit,
        context: Context
    ) {
        return mallDataSource.getMallAnnouncements(slug, onSuccess, onError, context)
    }

}