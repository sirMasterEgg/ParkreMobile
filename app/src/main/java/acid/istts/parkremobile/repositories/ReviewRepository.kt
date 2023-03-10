package acid.istts.parkremobile.repositories

import acid.istts.parkremobile.datasources.ReviewDataSource
import acid.istts.parkremobile.interfaces.ReviewDAO
import acid.istts.parkremobile.models.Review

class ReviewRepository(private val reviewDataSource: ReviewDataSource) : ReviewDAO {
    companion object {
        private var instance: ReviewRepository? = null
        fun getInstance(reviewDataSource: ReviewDataSource): ReviewRepository {
            if (instance == null) {
                instance = ReviewRepository(reviewDataSource)
            }
            return instance!!
        }
    }

    override suspend fun fetchReviews(): List<Review> {
        TODO("Not yet implemented")
    }

    override suspend fun getReview(id: Int): Review? {
        TODO("Not yet implemented")
    }

    override suspend fun createReview(review: Review): Boolean {
        TODO("Not yet implemented")
    }
}