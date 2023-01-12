package acid.istts.parkremobile.activities.staff

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import acid.istts.parkremobile.R
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class AnnouncementFragment(
    var announcementAdapter: AnnouncementAdapter
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

        val btnAdd : Button = view.findViewById(R.id.btnStaffAddAnn)
        btnAdd.setOnClickListener{
            val addAnnFragment = StaffAddAnnouncemenetFragment()
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.mainFragment, addAnnFragment)
            transaction.commit()
        }
    }
}