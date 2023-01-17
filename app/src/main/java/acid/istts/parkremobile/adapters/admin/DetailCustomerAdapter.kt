package acid.istts.parkremobile.adapters.admin

import acid.istts.parkremobile.R
import acid.istts.parkremobile.fragments.admin.AdminCustomerReservationDetailFragment
import acid.istts.parkremobile.models.Reservation
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class DetailCustomerAdapter (
    private val reservations : ArrayList<Reservation>
) : RecyclerView.Adapter<DetailCustomerAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val itemView = LayoutInflater.from(parent.context)
        return CustomViewHolder(itemView.inflate(
            R.layout.admin_detail_customer_layout, parent ,false
        ))
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val reservation = reservations[position]
        holder.bind(reservation)
    }

    override fun getItemCount(): Int {
        return reservations.size
    }

    class CustomViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        private val btnDetail : View = view.findViewById(R.id.btnCustomerDetailReservation)
        private val tvDate : TextView = view.findViewById(R.id.tvDetailCustomerDate)
        private val tvTime : TextView = view.findViewById(R.id.tvDetailCustomerTime)

        fun bind(reservation : Reservation) {
            tvDate.text = "Reservation Date : ${reservation.date}"
            tvTime.text = "Time : ${reservation.start_time} - ${reservation.end_time}"
            btnDetail.setOnClickListener{
                val activity = it!!.context as AppCompatActivity
                val fragment = AdminCustomerReservationDetailFragment(reservation)
                val transaction = activity.supportFragmentManager.beginTransaction()
                transaction.replace(R.id.framelayoutadmin, fragment)
                transaction.addToBackStack(null)
                transaction.commit()
            }
        }
    }
}