package acid.istts.parkremobile.activities.staff

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import acid.istts.parkremobile.R
import androidx.recyclerview.widget.RecyclerView

class HomeFragment(
    var reservationAdapter: ReservationAdapter
) : Fragment() {
    lateinit var rvStaffReservation : RecyclerView

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
        rvStaffReservation.adapter = reservationAdapter
    }
}