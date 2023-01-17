package acid.istts.parkremobile.adapters.customer

import acid.istts.parkremobile.R
import acid.istts.parkremobile.models.Vehicle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class VehicleAdapter(
    private var vehicles: ArrayList<Vehicle>,
    private val onEditClickListener: (Vehicle) -> Unit,
    private val onDeleteClickListener: (Vehicle) -> Unit
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
        holder.bind(vehicles[position])
    }

    override fun getItemCount(): Int {
        return vehicles.size
    }

    inner class VehicleViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val tvVehicleName: TextView = view.findViewById(R.id.tvNameVehicleCard)
        private val tvVehiclePlate: TextView = view.findViewById(R.id.tvPlateVehicleCard)
        private val ibEdit: ImageButton = view.findViewById(R.id.ibEditVehicleCard)
        private val ibDelete: ImageButton = view.findViewById(R.id.ibDeleteVehicleCard)

        fun bind(vehicle: Vehicle) {
            tvVehicleName.text = vehicle.name
            tvVehiclePlate.text = vehicle.plate

            ibEdit.setOnClickListener {
                onEditClickListener(vehicle)
            }
            ibDelete.setOnClickListener {
                onDeleteClickListener(vehicle)
            }
        }
    }
}