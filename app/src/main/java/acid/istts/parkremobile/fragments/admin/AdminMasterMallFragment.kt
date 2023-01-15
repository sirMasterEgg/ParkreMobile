package acid.istts.parkremobile.fragments.admin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import acid.istts.parkremobile.R
import acid.istts.parkremobile.adapters.admin.AnnoucementAdapter
import acid.istts.parkremobile.adapters.admin.MallAdapter
import acid.istts.parkremobile.models.Mall
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AdminMasterMallFragment : Fragment() {

    val dummymall : ArrayList<Mall> = arrayListOf()

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

        dummymall.add(Mall(1,"test aja","siapa anna?","jln 1",1,1,1,"test"))
        dummymall.add(Mall(2,"test aj2a","siapa anna?2","jln 2",2,2,2,"test"))

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

        val lm = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        val rvAdminmllList : RecyclerView = view.findViewById(R.id.rvadminmastermall)
        rvAdminmllList.layoutManager = lm
        rvAdminmllList.adapter = MallAdapter(dummymall)
    }


}