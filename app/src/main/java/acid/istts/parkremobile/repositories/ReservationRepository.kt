package acid.istts.parkremobile.repositories

import acid.istts.parkremobile.datasources.ReservationDataSource
import acid.istts.parkremobile.interfaces.ReservationDAO
import acid.istts.parkremobile.models.Reservation
import android.content.Context

class ReservationRepository(private val reservationDataSource: ReservationDataSource) : ReservationDAO {
    companion object {
        private var instance: ReservationRepository? = null
        fun getInstance(reservationDataSource: ReservationDataSource): ReservationRepository {
            if (instance == null) {
                instance = ReservationRepository(reservationDataSource)
            }
            return instance!!
        }
    }

    override fun fetchReservations(
        onSuccess: (String) -> Unit,
        onError: (String) -> Unit,
        context: Context,
        token: String
    ) {
        return reservationDataSource.fetchReservations(onSuccess, onError, context, token)
    }

    override suspend fun getReservation(id: Int): Reservation? {
        TODO("Not yet implemented")
    }

    override suspend fun createReservation(reservation: Reservation): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun updateReservation(reservation: Reservation): Boolean {
        TODO("Not yet implemented")
    }
}