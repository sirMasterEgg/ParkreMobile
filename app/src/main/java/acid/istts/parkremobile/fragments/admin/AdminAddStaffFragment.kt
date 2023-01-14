package acid.istts.parkremobile.fragments.admin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import acid.istts.parkremobile.R
import android.widget.Button

class AdminAddStaffFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_admin_add_staff2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val addstaffback : Button = view.findViewById(R.id.addstaffback)
        addstaffback.setOnClickListener{
            val addstfb = AdminMasterStaffFragment()
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.framelayoutadmin,addstfb)
            transaction.commit()
        }
    }
}