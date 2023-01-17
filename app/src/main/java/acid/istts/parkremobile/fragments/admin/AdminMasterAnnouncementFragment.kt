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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AdminMasterAnnouncementFragment(

) : Fragment() {
    val dummy : ArrayList<Announcement> = arrayListOf()
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

        dummy.add(Announcement(1,"test aja","siapa anna?",1,1,1,"mall anna"))
        dummy.add(Announcement(2,"test aja2","siapa anna?2",1,1,1,"mall anna"))
        dummy.add(Announcement(3,"test aja3","siapa anna?3",1,1,1,"mall anna"))

        val addannouncement : Button = view.findViewById(R.id.addannouncement)
        addannouncement.setOnClickListener{
            val addann = AdminAddAnnouncementFragment()
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.framelayoutadmin,addann)
            transaction.commit()
        }

        val lm = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        val rvAdminAnnList : RecyclerView = view.findViewById(R.id.rvAdminAnnList)
        rvAdminAnnList.layoutManager = lm
        rvAdminAnnList.adapter = AnnoucementAdapter(dummy)
    }
}