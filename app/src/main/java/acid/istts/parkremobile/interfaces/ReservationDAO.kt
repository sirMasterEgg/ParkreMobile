package acid.istts.parkremobile.interfaces

import acid.istts.parkremobile.models.Reservation
import android.content.Context

interface ReservationDAO {
    fun fetchReservations(onSuccess: (String) -> Unit, onError : (String) -> Unit, context: Context, token: String)
    suspend fun getReservation(id: Int): Reservation?
    suspend fun createReservation(reservation: Reservation): Boolean
    suspend fun updateReservation(reservation: Reservation): Boolean
    //TODO: getReservationByCustomer, getReservationByMall, getReservationByJob

}