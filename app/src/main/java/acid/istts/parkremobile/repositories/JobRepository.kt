package acid.istts.parkremobile.repositories

import acid.istts.parkremobile.datasources.JobDataSource
import acid.istts.parkremobile.interfaces.JobDAO
import acid.istts.parkremobile.models.Job

class JobRepository(private val jobDataSource: JobDataSource) : JobDAO {
    companion object {
        private var instance: JobRepository? = null
        fun getInstance(jobDataSource: JobDataSource): JobRepository {
            if (instance == null) {
                instance = JobRepository(jobDataSource)
            }
            return instance!!
        }
    }

    override suspend fun getJob(id: Int): Job? {
        return jobDataSource.getJob(id)
    }

    override suspend fun fetchJobs(): List<Job> {
        return jobDataSource.fetchJobs()
    }

    override suspend fun createJob(job: Job): Boolean {
        return jobDataSource.createJob(job)
    }

    override suspend fun updateJob(job: Job): Boolean {
        return jobDataSource.updateJob(job)
    }

    override suspend fun deleteJob(id: Int): Boolean {
        TODO("Not yet implemented")
    }
}