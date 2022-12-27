package acid.istts.parkremobile.datasources

import acid.istts.parkremobile.interfaces.JobDAO
import acid.istts.parkremobile.models.Job
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class JobDataSource(private val BASE_URL : String) : JobDAO {
    private val ioScope = CoroutineScope(Dispatchers.IO)

    companion object {
        private var instance: JobDataSource? = null
        fun getInstance(BASE_URL : String): JobDataSource {
            if (instance == null) {
                instance = JobDataSource(BASE_URL)
            }
            return instance!!
        }
    }

    override suspend fun fetchJobs(): List<Job> {
        TODO("Not yet implemented")
    }

    override suspend fun getJob(id: Int): Job? {
        TODO("Not yet implemented")
    }

    override suspend fun createJob(job: Job): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun updateJob(job: Job): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun deleteJob(id: Int): Boolean {
        TODO("Not yet implemented")
    }
}