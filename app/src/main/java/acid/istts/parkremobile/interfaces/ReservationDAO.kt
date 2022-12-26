package acid.istts.parkremobile.interfaces

import acid.istts.parkremobile.models.Reservation

interface ReservationDAO {
    suspend fun fetchReservations(): List<Reservation>
    suspend fun getReservation(id: Int): Reservation?
    suspend fun createReservation(reservation: Reservation): Boolean
    suspend fun updateReservation(reservation: Reservation): Boolean
    //TODO: getReservationByCustomer, getReservationByMall, getReservationByJob
}