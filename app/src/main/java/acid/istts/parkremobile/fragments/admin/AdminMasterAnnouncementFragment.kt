package acid.istts.parkremobile.fragments.admin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import acid.istts.parkremobile.R
import acid.istts.parkremobile.adapters.admin.AnnoucementAdapter
import acid.istts.parkremobile.models.Announcement

import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class AdminMasterAnnouncementFragment(

) : Fragment() {

    val announcements : ArrayList<Announcement> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_admin_master_announcement, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val addannouncement : Button = view.findViewById(R.id.addannouncement)
        addannouncement.setOnClickListener{
            val addann = AdminAddAnnouncementFragment()
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.framelayoutadmin,addann)
            transaction.commit()
        }


        val rvAdminAnnList : RecyclerView = view.findViewById(R.id.rvAdminAnnList)
        rvAdminAnnList.adapter = AnnoucementAdapter(announcements)
    }
}