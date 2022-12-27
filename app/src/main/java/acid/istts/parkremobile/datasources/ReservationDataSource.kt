package acid.istts.parkremobile.datasources

import acid.istts.parkremobile.interfaces.ReservationDAO
import acid.istts.parkremobile.models.Reservation
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class ReservationDataSource(private val BASE_URL : String) : ReservationDAO {
    private val ioScope = CoroutineScope(Dispatchers.IO)

    companion object {
        private var instance : ReservationDataSource? = null
        fun getInstance(BASE_URL : String) : ReservationDataSource {
            if (instance == null) {
                instance = ReservationDataSource(BASE_URL)
            }
            return instance!!
        }
    }

    override suspend fun fetchReservations(): List<Reservation> {
        TODO("Not yet implemented")
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