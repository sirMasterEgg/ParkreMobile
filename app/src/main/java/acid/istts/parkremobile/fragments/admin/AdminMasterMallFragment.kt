package acid.istts.parkremobile.fragments.admin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import acid.istts.parkremobile.R
import android.widget.Button

class AdminMasterMallFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_admin_master_mall, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val addmall : Button = view.findViewById(R.id.addmall)
        addmall.setOnClickListener{
            val addmll = AdminAddMallFragment()
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.framelayoutadmin,addmll)
            transaction.commit()
        }

        val addsegmen : Button = view.findViewById(R.id.addsegmen)
        addsegmen.setOnClickListener{
            val addsgmt = AdminAddSegmenFragment()
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.framelayoutadmin,addsgmt)
            transaction.commit()
        }
    }


}