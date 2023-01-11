package acid.istts.parkremobile.activities.staff

import acid.istts.parkremobile.R
import acid.istts.parkremobile.models.Reservation
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ReservationAdapter (
var reservationList: ArrayList<Reservation>
) :  RecyclerView.Adapter<ReservationAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val itemView = LayoutInflater.from(parent.context)
        return CustomViewHolder(itemView.inflate(
            R.layout.staff_reservation_layout, parent ,false
        ))
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val reservation = reservationList[position]
        holder.bind(reservation)
    }

    override fun getItemCount(): Int {
        return reservationList.size
    }

    class CustomViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        private val btnDetailReservation : Button = view.findViewById(R.id.btnDetailReservation)
        private val tvSegment : TextView = view.findViewById(R.id.tvSegment)
        private val tvStart : TextView = view.findViewById(R.id.tvStart)
        private val tvEnd : TextView = view.findViewById(R.id.tvEnd)

        fun bind(reservation : Reservation) {
            tvSegment.text = reservation.segmentation_id.toString()
            tvStart.text = reservation.start_time
            tvEnd.text = reservation.end_time
            btnDetailReservation.setOnClickListener{
                // TODO : Open Detail Reservation
            }
        }
    }
}