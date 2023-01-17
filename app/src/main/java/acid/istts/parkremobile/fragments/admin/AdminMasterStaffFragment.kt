package acid.istts.parkremobile.fragments.admin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import acid.istts.parkremobile.R
import acid.istts.parkremobile.adapters.admin.StaffAdapter
import acid.istts.parkremobile.models.Staff
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AdminMasterStaffFragment(
    var staffAdapter: StaffAdapter
) : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_admin_master_staff2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvStaff : RecyclerView = view.findViewById(R.id.rvMasterStaff)
        rvStaff.adapter = staffAdapter
        rvStaff.layoutManager = LinearLayoutManager(context)

        val addstaff : Button = view.findViewById(R.id.addstaff)
        addstaff.setOnClickListener{
            val addstf = AdminAddStaffFragment()
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.framelayoutadmin,addstf)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        val addjob : Button = view.findViewById(R.id.addjob)
        addjob.setOnClickListener{
            val addjb = AdminAddJobFragment()
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.framelayoutadmin,addjb)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }
}