package acid.istts.parkremobile.fragments.admin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import acid.istts.parkremobile.R
import acid.istts.parkremobile.models.Reservation
import android.widget.TextView

class AdminCustomerReservationDetailFragment(
    var reservation: Reservation
) : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_admin_customer_reservation_detail,
            container,
            false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tvStart : TextView = view.findViewById(R.id.tvReservationDetailStartTime)
        val tvEnd : TextView = view.findViewById(R.id.tvReservationDetailEndTime)
        val tvDate : TextView = view.findViewById(R.id.tvReservationDetailDate)
        val tvStatus : TextView = view.findViewById(R.id.tvReservationDetailStatus)
        val tvVehicle : TextView = view.findViewById(R.id.tvReservationDetailVehiclePlate)
        val tvPrice : TextView = view.findViewById(R.id.tvReservationDetailPrice)
        val tvUserName : TextView = view.findViewById(R.id.tvReservationDetailUserName)
        val tvMallName : TextView = view.findViewById(R.id.tvReservationDetailMallName)
        val tvSegmentationName : TextView = view.findViewById(R.id.tvReservationDetailSegmentationName)

        if(reservation.status == 1) {
            tvStatus.text = "Reservation : Payment Success"
        } else {
            tvStatus.text = "Reservation : Waiting Payment"
        }

        tvStart.text = "Start Time : ${reservation.start_time}"
        tvEnd.text = "End Time : ${reservation.end_time}"
        tvDate.text = "Date : ${reservation.date}"
        tvVehicle.text = "Vehicle Plate : ${reservation.vehicle_plate}"
        tvPrice.text = "Price : ${reservation.price}"
        tvUserName.text = "User Name : ${reservation.user_name}"
        tvMallName.text = "Mall Name : ${reservation.mall_name}"
        tvSegmentationName.text = "Segmentation Name : ${reservation.segmentation_name}"







    }
}