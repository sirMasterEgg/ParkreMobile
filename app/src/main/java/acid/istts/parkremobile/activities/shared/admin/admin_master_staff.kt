package acid.istts.parkremobile.activities.shared.admin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import acid.istts.parkremobile.R
import android.widget.Button

class admin_master_staff : Fragment() {
    lateinit var admin_master_staff : admin_master_staff
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        admin_master_staff = admin_master_staff()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_admin_master_staff, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val addstaff : Button = view.findViewById(R.id.addstaff)
        addstaff.setOnClickListener{
            val addstf = admin_add_staff()
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.framelayoutadmin,addstf)
            transaction.commit()
        }

        val addjob : Button = view.findViewById(R.id.addjob)
        addjob.setOnClickListener{
            val addjb = admin_add_job()
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.framelayoutadmin,addjb)
            transaction.commit()
        }
    }
}