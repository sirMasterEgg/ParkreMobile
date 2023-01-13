package acid.istts.parkremobile.fragments.staff

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import acid.istts.parkremobile.R
import acid.istts.parkremobile.adapters.staff.AnnouncementAdapter
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class StaffAnnouncementFragment(
    var announcementAdapter: AnnouncementAdapter,
    var token: String
) : Fragment() {
    lateinit var rvStaffAnnList : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_staff_announcement, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvStaffAnnList = view.findViewById(R.id.rvStaffAnnList)

        rvStaffAnnList.adapter = announcementAdapter
        rvStaffAnnList.layoutManager = LinearLayoutManager(context)

        val btnAdd : Button = view.findViewById(R.id.btnStaffAddAnn)
        btnAdd.setOnClickListener{
            val addAnnFragment = StaffAddAnnouncemenetFragment(token)
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.mainFragment, addAnnFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }
}