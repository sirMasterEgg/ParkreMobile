package acid.istts.parkremobile.adapters.customer

import acid.istts.parkremobile.R
import acid.istts.parkremobile.models.Reservation
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ReservationAdapter(
    private val reservations: ArrayList<Reservation>
): RecyclerView.Adapter<ReservationAdapter.ReservationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReservationViewHolder {
        val itemView = LayoutInflater.from(parent.context)
        return ReservationViewHolder(itemView.inflate(
            R.layout.customer_reservation_card, parent ,false
        ))
    }

    override fun onBindViewHolder(holder: ReservationViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return reservations.size
    }

    class ReservationViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val tvMall: TextView = itemView.findViewById(R.id.tvMallReservationCard)
        private val tvSegmentation: TextView = itemView.findViewById(R.id.tvSegmentationReservationCard)
        private val tvDate: TextView = itemView.findViewById(R.id.tvDateReservationCard)

//        fun bind(reservation: Reservation) {
//            tvMall.text = reservation.mall
//            tvSegmentation.text = reservation.segmentation
//            tvDate.text = reservation.date
//        }
    }
}