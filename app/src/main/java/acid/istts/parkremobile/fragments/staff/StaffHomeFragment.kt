package acid.istts.parkremobile.fragments.staff

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import acid.istts.parkremobile.R
import acid.istts.parkremobile.adapters.staff.ReservationAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class StaffHomeFragment(
    var reservationAdapter: ReservationAdapter
) : Fragment() {
    private lateinit var rvStaffReservation : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_staff_home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvStaffReservation = view.findViewById(R.id.rvStaffReservation)

        val layoutManager = LinearLayoutManager(context)
        rvStaffReservation.layoutManager = layoutManager
        rvStaffReservation.adapter = reservationAdapter
    }
}