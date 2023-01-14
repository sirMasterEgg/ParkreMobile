package acid.istts.parkremobile.fragments.staff

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import acid.istts.parkremobile.R
import acid.istts.parkremobile.models.Reservation
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class StaffReservationDetailFragment(
    val reservation : Reservation
) : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_staff_reservation_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnBack : Button = view.findViewById(R.id.btnBackDetail)
        val start : TextView = view.findViewById(R.id.tvStartRes)
        val end : TextView = view.findViewById(R.id.tvEndRes)
        val plate_num : TextView = view.findViewById(R.id.tvPlateNumber)
        val res_price : TextView = view.findViewById(R.id.tvResPrice)
        val user_name : TextView = view.findViewById(R.id.tvResDetailUserName)
        val segmentation_name : TextView = view.findViewById(R.id.tvSegmentationName)
        val mall_name : TextView = view.findViewById(R.id.tvMallName)

        start.text = "Start At : ${reservation.start_time}"
        end.text = "End At : ${reservation.end_time}"
        plate_num.text = "Plate Number : ${reservation.vehicle_plate}"
        res_price.text = "Price : ${reservation.price}"
        user_name.text = "User Name : ${reservation.user_name}"
        segmentation_name.text = "Segmentation Name : ${reservation.segmentation_name}"
//        mall_name.text = "Mall Name : ${reservation.mall_name}"
        mall_name.text = "Mall Name : <Mall Name>"

        btnBack.setOnClickListener {
            val supportFragmentManager = activity?.supportFragmentManager
            supportFragmentManager?.popBackStackImmediate()
        }
    }
}