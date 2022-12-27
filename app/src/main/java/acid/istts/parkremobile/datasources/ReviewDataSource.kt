package acid.istts.parkremobile.datasources

import acid.istts.parkremobile.interfaces.ReviewDAO
import acid.istts.parkremobile.models.Review
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class ReviewDataSource(private val BASE_URL : String) : ReviewDAO {
    private val ioScope = CoroutineScope(Dispatchers.IO)

    companion object {
        private var instance : ReviewDataSource? = null
        fun getInstance(BASE_URL : String) : ReviewDataSource {
            if (instance == null) {
                instance = ReviewDataSource(BASE_URL)
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