package acid.istts.parkremobile.interfaces

import acid.istts.parkremobile.models.Job

interface JobDAO {
    suspend fun fetchJobs(): List<Job>
    suspend fun getJob(id: Int): Job?
    suspend fun createJob(job: Job): Boolean
    suspend fun updateJob(job: Job): Boolean
    suspend fun deleteJob(id: Int): Boolean
}