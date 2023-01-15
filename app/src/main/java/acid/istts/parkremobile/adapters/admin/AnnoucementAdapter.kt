package acid.istts.parkremobile.adapters.admin

import acid.istts.parkremobile.R
import acid.istts.parkremobile.adapters.staff.AnnouncementAdapter
import acid.istts.parkremobile.fragments.admin.AdminMasterAnnouncementFragment
import acid.istts.parkremobile.fragments.staff.StaffAnnouncementDetailFragment
import acid.istts.parkremobile.models.Announcement
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView

class AnnoucementAdapter(
    private val announcements : ArrayList<Announcement>
        ): RecyclerView.Adapter<AnnoucementAdapter.CustomViewHolders>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int ): CustomViewHolders {
        val itemView = LayoutInflater.from(parent.context)
        return CustomViewHolders(itemView.inflate(
            R.layout.admin_recyclerview_announcement, parent ,false
        ))
    }

    override fun onBindViewHolder(holder: CustomViewHolders, position: Int) {
        val ann = announcements[position]
    }

    override fun getItemCount(): Int {
        return announcements.size
    }

    class CustomViewHolders(view: View) : RecyclerView.ViewHolder(view) {
        private val AnnouncementApprove : Button = view.findViewById(R.id.AnnouncementApprove)
        private val DetailAnnouncement : Button = view.findViewById(R.id.DetailAnnouncement)
        private val DeleteAnnouncement : Button = view.findViewById((R.id.DeleteAnnouncement))
        private val AdminAnnHeader : TextView = view.findViewById(R.id.AdminAnnHeader)

    }



}