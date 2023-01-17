package acid.istts.parkremobile.adapters.customer

import acid.istts.parkremobile.R
import acid.istts.parkremobile.models.Reservation
import acid.istts.parkremobile.models.Transaction
import acid.istts.parkremobile.utils.CurrencyUtils.toRupiah
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ReservationAdapter(
    private val reservations: ArrayList<Transaction>
): RecyclerView.Adapter<ReservationAdapter.ReservationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReservationViewHolder {
        val itemView = LayoutInflater.from(parent.context)
        return ReservationViewHolder(itemView.inflate(
            R.layout.customer_reservation_card, parent ,false
        ))
    }

    override fun onBindViewHolder(holder: ReservationViewHolder, position: Int) {
        holder.bind(reservations[position])
    }

    override fun getItemCount(): Int {
        return reservations.size
    }

    class ReservationViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val tvMall: TextView = itemView.findViewById(R.id.tvMallReservationCard)
        private val tvPrice: TextView = itemView.findViewById(R.id.tvPriceReservationCard)
        private val tvDate: TextView = itemView.findViewById(R.id.tvDateReservationCard)
        private val btnDetail: Button = itemView.findViewById(R.id.btnDetailReservationCard)

        fun bind(reservation: Transaction) {
            tvMall.text = reservation.mall_name
            tvPrice.text = reservation.price.toRupiah()
            tvDate.text = reservation.date

        }
    }
}