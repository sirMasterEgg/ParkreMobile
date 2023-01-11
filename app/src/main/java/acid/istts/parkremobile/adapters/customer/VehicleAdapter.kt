package acid.istts.parkremobile.adapters.customer

import acid.istts.parkremobile.R
import acid.istts.parkremobile.models.Vehicle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VehicleAdapter(
    private var vehicles: ArrayList<Vehicle>
): RecyclerView.Adapter<VehicleAdapter.VehicleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VehicleViewHolder {
        val itemView = LayoutInflater.from(parent.context)
        return VehicleViewHolder(
            itemView.inflate(
                R.layout.customer_vehicle_card, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: VehicleViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return vehicles.size
    }

    class VehicleViewHolder(view: View): RecyclerView.ViewHolder(view) {

//        fun bind(reservation: Reservation) {
//            tvMall.text = reservation.mall
//            tvSegmentation.text = reservation.segmentation
//            tvDate.text = reservation.date
//        }
    }
}