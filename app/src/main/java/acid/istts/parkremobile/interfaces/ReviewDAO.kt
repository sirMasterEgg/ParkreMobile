package acid.istts.parkremobile.interfaces

import acid.istts.parkremobile.models.Review

interface ReviewDAO {
    suspend fun fetchReviews(): List<Review>
    suspend fun getReview(id: Int): Review?
    suspend fun createReview(review: Review): Boolean
}