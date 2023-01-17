package acid.istts.parkremobile.fragments.admin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import acid.istts.parkremobile.R
import acid.istts.parkremobile.adapters.admin.StaffAdapter
import acid.istts.parkremobile.models.Staff
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdminDetailStaffFragment(
    var staff : Staff
) : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_admin_detail_staff, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tvName : TextView = view.findViewById(R.id.tvStaffDetailName)
        val tvUsername : TextView = view.findViewById(R.id.tvStaffDetailUsername)
        val tvAddress : TextView = view.findViewById(R.id.tvStaffDetailAddress)
        val tvPhone : TextView = view.findViewById(R.id.tvStaffDetailPhone)
    }
}